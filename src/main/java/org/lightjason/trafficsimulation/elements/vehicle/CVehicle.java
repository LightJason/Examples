/*
 * @cond LICENSE
 * ######################################################################################
 * # LGPL License                                                                       #
 * #                                                                                    #
 * # This file is part of the LightJason AgentSpeak(L++) Traffic-Simulation             #
 * # Copyright (c) 2017, LightJason (info@lightjason.org)                               #
 * # This program is free software: you can redistribute it and/or modify               #
 * # it under the terms of the GNU Lesser General Public License as                     #
 * # published by the Free Software Foundation, either version 3 of the                 #
 * # License, or (at your option) any later version.                                    #
 * #                                                                                    #
 * # This program is distributed in the hope that it will be useful,                    #
 * # but WITHOUT ANY WARRANTY; without even the implied warranty of                     #
 * # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                      #
 * # GNU Lesser General Public License for more details.                                #
 * #                                                                                    #
 * # You should have received a copy of the GNU Lesser General Public License           #
 * # along with this program. If not, see http://www.gnu.org/licenses/                  #
 * ######################################################################################
 * @endcond
 */

package org.lightjason.trafficsimulation.elements.vehicle;

import cern.colt.matrix.tdouble.DoubleMatrix1D;
import cern.colt.matrix.tdouble.impl.DenseDoubleMatrix1D;
import cern.jet.math.tdouble.DoubleFunctions;
import com.codepoetics.protonpack.StreamUtils;
import com.google.common.util.concurrent.AtomicDouble;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.lightjason.agentspeak.action.binding.IAgentAction;
import org.lightjason.agentspeak.action.binding.IAgentActionFilter;
import org.lightjason.agentspeak.action.binding.IAgentActionName;
import org.lightjason.agentspeak.agent.IAgent;
import org.lightjason.agentspeak.beliefbase.IBeliefbaseOnDemand;
import org.lightjason.agentspeak.configuration.IAgentConfiguration;
import org.lightjason.agentspeak.language.CLiteral;
import org.lightjason.agentspeak.language.CRawTerm;
import org.lightjason.agentspeak.language.ILiteral;
import org.lightjason.agentspeak.language.ITerm;
import org.lightjason.agentspeak.language.instantiable.IInstantiable;
import org.lightjason.agentspeak.language.instantiable.plan.trigger.CTrigger;
import org.lightjason.agentspeak.language.instantiable.plan.trigger.ITrigger;
import org.lightjason.agentspeak.language.variable.CConstant;
import org.lightjason.agentspeak.language.variable.IVariable;
import org.lightjason.trafficsimulation.common.CCommon;
import org.lightjason.trafficsimulation.common.CMath;
import org.lightjason.trafficsimulation.common.EDirection;
import org.lightjason.trafficsimulation.elements.EUnit;
import org.lightjason.trafficsimulation.elements.IBaseObject;
import org.lightjason.trafficsimulation.elements.IObject;
import org.lightjason.trafficsimulation.elements.environment.IEnvironment;
import org.lightjason.trafficsimulation.ui.api.CAnimation;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * vehicle agent
 */
@IAgentAction
public final class CVehicle extends IBaseObject<IVehicle> implements IVehicle
{
    /**
     * serial id
     */
    private static final long serialVersionUID = 3822143462033345857L;
    /**
     * viewrange in meter
     */
    private static final double VIEWRANGE = 150;
    /**
     * literal functor
     */
    private static final String FUNCTOR = "vehicle";
    /**
     * vehicle type
     */
    private final ETYpe m_type;
    /**
     * environment
     */
    private final IEnvironment m_environment;
    /**
     * accelerate speed in m/sec^2
     * @warning must be in (0, infinity)
     */
    @Nonnegative
    private final double m_acceleration;
    /**
     * decelerate speed in m/sec^2
     * @warning must be in (0, infinity)
     */
    private final double m_deceleration;
    /**
     * maximum speed
     */
    private final double m_maximumspeed;
    /**
     * current speed in km/h
     */
    private final AtomicDouble m_speed = new AtomicDouble( );
    /**
     * panelize value
     */
    private final AtomicDouble m_panelize = new AtomicDouble();
    /**
     * lane index cache for access from variable builder
     */
    private final AtomicDouble m_lane = new AtomicDouble();
    /*
     * current position on lane / cell position
     */
    private final DoubleMatrix1D m_position;
    /**
     * goal position (x-coordinate)
     */
    private final int m_goal;
    /**
     * backward view
     */
    private final CEnvironmentView m_viewrange;
    /**
     * view range size in meter
     */
    private final double m_viewrangesize;

    /**
     * ctor
     *
     * @param p_configuration agent configuration
     * @param p_id name of the object
     * @param p_start start position
     * @param p_goal goal position (x-coordinate)
     * @param p_acceleration accelerate speed
     * @param p_deceleration decelerate speed
     */
    private CVehicle( @Nonnull final IAgentConfiguration<IVehicle> p_configuration, @Nonnull final String p_id,
                      @Nonnull final IEnvironment p_environment, @Nonnull final ETYpe p_type,
                      @Nonnull final DoubleMatrix1D p_start, @Nonnegative final int p_goal,
                      @Nonnegative final double p_maximumspeed, @Nonnegative final double p_acceleration, @Nonnegative final double p_deceleration
    )
    {
        super( p_configuration, FUNCTOR, p_id );

        m_type = p_type;
        m_goal = p_goal;
        m_position = p_start;
        m_viewrangesize = VIEWRANGE;
        m_environment = p_environment;
        m_maximumspeed = p_maximumspeed;
        m_acceleration = p_acceleration;
        m_deceleration = p_deceleration;

        m_lane.set( p_start.getQuick( 0 ) );
        m_viewrange = new CEnvironmentView(
            Collections.unmodifiableSet(
                CMath.cellcircle( EUnit.INSTANCE.metertocell( m_viewrangesize ) ).collect( Collectors.toSet() )
            )
        );
        m_beliefbase.add( m_viewrange.create( "view", m_beliefbase ) );

        if ( EUnit.INSTANCE.accelerationtospeed( m_acceleration ).doubleValue() > m_maximumspeed )
            throw new RuntimeException( "maximum acceleration is higher than maximum speed" );
        if ( ( m_acceleration < 2 ) || ( m_deceleration < 2 ) )
            throw new RuntimeException( "acceleration or deceleration is to low" );
        if ( m_deceleration <= m_acceleration )
            throw new RuntimeException( "deceleration should be greater or equal than acceleration" );

        CAnimation.EInstance.INSTANCE.send( EStatus.INITIALIZE, this );
    }

    @Nonnull
    @Override
    public final DoubleMatrix1D position()
    {
        return m_position;
    }

    @Nonnull
    @Override
    public final DoubleMatrix1D nextposition()
    {
        return EDirection.FORWARD.position(
            this.position(),
            new DenseDoubleMatrix1D( new double[]{this.position().get( 0 ), m_goal} ),
            EUnit.INSTANCE.speedtocell( this.speed() ).doubleValue()
        );
    }

    @Nonnull
    @Override
    public final IObject<IVehicle> release()
    {
        CAnimation.EInstance.INSTANCE.send( EStatus.RELEASE, this );
        return this;
    }

    @Override
    public final Map<String, Object> map( @Nonnull final EStatus p_status )
    {
        final DoubleMatrix1D l_position = this.position().copy();

        // an concurrency excpetion can be thrown, because execution call
        // can be done in parallel, so we need to create a more secured structure
        Object[] l_beliefs;
        while ( true )
        {
            try
            {
                l_beliefs = m_beliefbase.stream().map( Object::toString ).toArray();
                break;
            }
            catch ( final ConcurrentModificationException l_exception )
            {
                // ignore and just do it again
            }
        }


        return StreamUtils.zip(
            Stream.of( "type", "status", "id", "y", "x", "goal", "speed", "maxspeed", "acceleration", "deceleration", "distance", "belief" ),
            Stream.of( this.type().toString(),
                       p_status.toString(),
                       this.id(),
                       l_position.get( 0 ),
                       l_position.get( 1 ),
                       m_goal,
                       m_speed.get(),
                       m_maximumspeed,
                       m_acceleration,
                       m_deceleration,
                       EUnit.INSTANCE.celltokilometer( l_position.getQuick( 1 ) ).doubleValue(),
                       l_beliefs
            ),
            ImmutablePair::new
        ).collect( Collectors.toMap( ImmutablePair::getLeft, ImmutablePair::getRight ) );
    }

    @Nonnull
    @Override
    public final DoubleMatrix1D worldposition()
    {
        return m_position.copy()
                         .assign( DoubleFunctions.plus( 1 ) )
                         .assign( DoubleFunctions.mult( EUnit.INSTANCE.cellsize().doubleValue() / 2 ) );
    }

    @Override
    protected final Stream<ITerm> staticliteral( final IObject<?> p_object )
    {
        return Stream.of(
            CLiteral.from( "lane", CRawTerm.from( this.position().get( 0 ) + 1 ) ),
            CLiteral.from( "speed", CRawTerm.from( m_speed.get() ) ),
            CLiteral.from( "distance", CRawTerm.from( EUnit.INSTANCE.celltometer( CMath.distance( this.position(), p_object.position() ) ) ) ),
            CLiteral.from( "direction",
                           CLiteral.from(
                               EDirection.byAngle(
                                   CMath.angle(
                                       this.worldmovement(),
                                       this.worldposition().assign( p_object.worldposition(), DoubleFunctions.minus )
                                   ).doubleValue() + 22.5D
                               ).toString().toLowerCase( Locale.ROOT )
                           )
            )
        );
    }

    @Override
    @Nonnegative
    public final double penalty()
    {
        return m_panelize.get();
    }

    @Override
    @Nonnegative
    public final double acceleration()
    {
        return m_acceleration;
    }

    @Override
    @Nonnegative
    public final double deceleration()
    {
        return m_deceleration;
    }

    @Override
    public final double maximumspeed()
    {
        return m_maximumspeed;
    }

    @Override
    public final Number lane()
    {
        return m_lane.get();
    }

    @Override
    public final DoubleMatrix1D worldmovement()
    {
        final DoubleMatrix1D l_position = this.worldposition();
        final DoubleMatrix1D l_direction = l_position.copy();
        l_direction.setQuick( 1, l_direction.getQuick( 1 ) + m_viewrangesize );

        return l_direction.assign( l_position, DoubleFunctions.minus );
    }

    @Override
    public final double speed()
    {
        return m_speed.get();
    }

    @Nonnull
    @Override
    public final IVehicle penalty( @Nonnull final Number p_value )
    {
        m_panelize.addAndGet( p_value.doubleValue() );
        return this;
    }

    @Override
    public final ETYpe type()
    {
        return m_type;
    }

    @Override
    public final IVehicle call() throws Exception
    {
        // update beliefbase
        m_viewrange.run();

        super.call();
        // give environment the data if it is a user car
        if ( !m_environment.move( this ) )
            this.oncollision();

        return this;
    }

    /**
     * runs collision handling
     */
    private void oncollision()
    {
        if ( m_type.equals( ETYpe.USERVEHICLE ) )
            m_environment.trigger( CTrigger.from( ITrigger.EType.ADDGOAL, CLiteral.from( "vehicle/usercollision", CRawTerm.from( this ) ) ) );
        else
            this.trigger( CTrigger.from( ITrigger.EType.ADDGOAL, CLiteral.from( "vehicle/collision" ) ) );
    }



    // --- agent actions ---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * accelerate
     */
    @IAgentActionFilter
    @IAgentActionName( name = "vehicle/accelerate" )
    private void accelerate( final Number p_strength )
    {
        final double l_value = m_speed.get() + EUnit.INSTANCE.accelerationtospeed(
            m_acceleration * Math.max( 0, Math.min( 1, p_strength.doubleValue() ) )
        ).doubleValue();

        if (  l_value > m_maximumspeed )
            throw new RuntimeException( MessageFormat.format( "cannot increment speed: {0}", this ) );

        m_speed.set( l_value );
    }

    /**
     * decelerate
     */
    @IAgentActionFilter
    @IAgentActionName( name = "vehicle/decelerate" )
    private void decelerate( final Number p_strength )
    {
        final double l_value = m_speed.get() - EUnit.INSTANCE.accelerationtospeed(
            m_deceleration * Math.max( 0, Math.min( 1, p_strength.doubleValue() ) )
        ).doubleValue();

        if (  l_value < 0 )
            throw new RuntimeException( MessageFormat.format( "cannot decrement speed: {0}", this ) );

        m_speed.set( l_value );
    }

    /**
     * swing-out
     */
    @IAgentActionFilter
    @IAgentActionName( name = "vehicle/pullout" )
    private void pullout()
    {
        final Number l_lane = this.position().get( 0 ) + ( m_goal == 0 ? 1 : -1 );
        if ( !m_environment.lanechange( this, l_lane ) )
            this.oncollision();
        else
            m_lane.set( l_lane.intValue() );
    }

    /**
     * go back into lane
     */
    @IAgentActionFilter
    @IAgentActionName( name = "vehicle/pullin" )
    private void pullin()
    {
        final Number l_lane = this.position().get( 0 ) + ( m_goal == 0 ? -1 : 1 );
        if ( !m_environment.lanechange( this, l_lane ) )
            this.oncollision();
        else
            m_lane.set( l_lane.intValue() );
    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * generator
     * @see https://en.wikipedia.org/wiki/Orders_of_magnitude_(acceleration)
     */
    public static final class CGenerator extends IBaseGenerator<IVehicle> implements Callable<IVehicle>
    {
        /**
         * counter
         */
        private static final AtomicLong COUNTER = new AtomicLong();
        /**
         * visibility within the UI
         */
        private final boolean m_visible;
        /**
         * vehicle type
         */
        private final ETYpe m_type;


        /**
         * generator
         *
         * @param p_stream stream
         * @param p_uiaccessiable generated cars are ui-accessable
         * @throws Exception on any error
         */
        public CGenerator( @Nonnull final InputStream p_stream, final boolean p_uiaccessiable, final ETYpe p_type ) throws Exception
        {
            super( p_stream, CVehicle.class, new CVariableBuilder() );
            m_visible = p_uiaccessiable;
            m_type = p_type;
        }

        @Override
        public final IGenerator<IVehicle> resetcount()
        {
            COUNTER.set( 0 );
            return this;
        }

        @Override
        public final IVehicle call() throws Exception
        {
            return this.generatesingle();
        }

        @Nullable
        @Override
        @SuppressWarnings( "unchecked" )
        protected final Triple<IVehicle, Boolean, Stream<String>> generate( @Nullable final Object... p_data )
        {
            if ( ( p_data == null ) || ( p_data.length < 6 ) )
                throw new RuntimeException( CCommon.languagestring( this, "parametercount" ) );

            return new ImmutableTriple<>(
                new CVehicle(
                    m_configuration,
                    MessageFormat.format( "{0}{1}", FUNCTOR, COUNTER.getAndIncrement() ),
                    (IEnvironment) p_data[0],
                    m_type,

                    (DoubleMatrix1D) p_data[1],
                    ( (Number) p_data[2] ).intValue(),

                    ( (Number) p_data[3] ).doubleValue(),
                    ( (Number) p_data[4] ).doubleValue(),
                    ( (Number) p_data[5] ).doubleValue()
                ),
                m_visible,
                Stream.of( FUNCTOR )
            );
        }
    }


    /**
     * variable builder of vehicle
     */
    private static final class CVariableBuilder extends IBaseVariableBuilder
    {

        @Override
        public final Stream<IVariable<?>> apply( final IAgent<?> p_agent, final IInstantiable p_instance )
        {
            final IVehicle l_vehicle = p_agent.<IVehicle>raw();
            return Stream.concat(
                super.apply( p_agent, p_instance ),
                Stream.of(
                    new CConstant<>( "CurrentSpeed", l_vehicle.speed() ),
                    new CConstant<>( "CurrentLane", l_vehicle.lane().intValue() + 1 ),
                    new CConstant<>( "Acceleration", l_vehicle.acceleration() ),
                    new CConstant<>( "Deceleration", l_vehicle.deceleration() )
                )
            );
        }
    }

    /**
     * on-demand beliefbase
     */
    private final class CEnvironmentView extends IBeliefbaseOnDemand<IVehicle> implements Runnable
    {
        /**
         * cell position
         */
        private final Set<DoubleMatrix1D> m_position;
        /**
         * object cache with distance and literal
         */
        private final List<ILiteral> m_cache = new CopyOnWriteArrayList<>();

        /**
         * ctor
         *
         * @param p_position cell position relative to object position
         */
        CEnvironmentView( final Set<DoubleMatrix1D> p_position )
        {
            m_position = p_position;
        }

        @Override
        public final boolean empty()
        {
            return m_cache.isEmpty();
        }

        @Override
        public final int size()
        {
            return m_cache.size();
        }

        @Nonnull
        @Override
        public final Stream<ILiteral> streamLiteral()
        {
            return m_cache.stream();
        }

        @Override
        public final boolean containsLiteral( @Nonnull final String p_key )
        {
            return "vehicle".equals( p_key );
        }

        @Nonnull
        @Override
        public final Collection<ILiteral> literal( @Nonnull final String p_key )
        {
            return m_cache;
        }

        @Override
        public final void run()
        {
            m_cache.clear();
            m_environment.get(
                m_position.parallelStream()
                          .map( i -> new DenseDoubleMatrix1D( CVehicle.this.m_position.toArray() ).assign( i, DoubleFunctions.plus ) )
                          .filter( m_environment::isinside )
            )
                 .parallel()
                 .filter( i -> !i.equals( CVehicle.this ) )
                 .map( i -> new ImmutablePair<>( EUnit.INSTANCE.celltometer( CMath.distance( CVehicle.this.position(), i.position() ) ),  i ) )
                 .sorted( Comparator.comparingDouble( i -> i.getLeft().doubleValue() ) )
                 .map( ImmutablePair::getRight )
                 .map( i -> i.literal( CVehicle.this ) )
                 .forEachOrdered( m_cache::add );

        }
    }
}
