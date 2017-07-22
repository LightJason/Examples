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

import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import com.google.common.util.concurrent.AtomicDouble;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.lightjason.agentspeak.action.binding.IAgentAction;
import org.lightjason.agentspeak.action.binding.IAgentActionFilter;
import org.lightjason.agentspeak.action.binding.IAgentActionName;
import org.lightjason.agentspeak.configuration.IAgentConfiguration;
import org.lightjason.agentspeak.language.CLiteral;
import org.lightjason.agentspeak.language.ILiteral;
import org.lightjason.agentspeak.language.instantiable.plan.trigger.CTrigger;
import org.lightjason.agentspeak.language.instantiable.plan.trigger.ITrigger;
import org.lightjason.trafficsimulation.elements.CUnit;
import org.lightjason.trafficsimulation.elements.IBaseObject;
import org.lightjason.trafficsimulation.elements.IObject;
import org.lightjason.trafficsimulation.elements.environment.IEnvironment;
import org.lightjason.trafficsimulation.ui.api.CAnimation;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
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
     * literal functor
     */
    private static final String FUNCTOR = "vehicle";
    /**
     * user definied vehicle
     */
    private final boolean m_userdefinied;
    /**
     * environment
     */
    private final IEnvironment m_environment;
    /**
     * accelerate speed in m/sec^
     * @warning must be in (0, infinity)
     */
    @Nonnegative
    private final double m_accelerate;
    /**
     * decelerate speed in m/sec^
     * @warning must be in (infinity, 0)
     */
    private final double m_decelerate;
    /**
     * maximum speed
     */
    private final double m_maximumspeed;
    /**
     * current speed in km/h
     */
    private final AtomicDouble m_speed = new AtomicDouble();
    /**
     * panelize value
     */
    private final AtomicDouble m_panelize = new AtomicDouble();
    /*
     * current position on lane / cell position
     */
    private final DoubleMatrix1D m_position = new DenseDoubleMatrix1D( new double[]{0, 0} );

    /**
     * ctor
     *
     * @param p_configuration agent configuration
     * @param p_id name of the object
     * @param p_accelerate accelerate speed
     * @param p_decelerate decelerate speed
     *
     * @todo remove fixed values
     */
    private CVehicle( @Nonnull final IAgentConfiguration<IVehicle> p_configuration,
                      @Nonnull final String p_id,
                      @Nonnull final IEnvironment p_environment,
                      @Nonnegative final double p_accelerate, @Nonnegative final double p_decelerate, @Nonnegative final double p_maximumspeed,
                      final boolean p_userdefinied
    )
    {
        super( p_configuration, FUNCTOR, p_id );
        //m_accelerate = p_accelerate;
        //m_decelerate = p_decelerate;
        m_maximumspeed = p_maximumspeed;
        m_environment = p_environment;
        m_userdefinied = p_userdefinied;

        m_accelerate = 15;
        m_decelerate = 25;
        m_speed.set( 20 );

        CAnimation.CInstance.INSTANCE.vehicle( CAnimation.CInstance.EStatus.CREATE, this );
    }

    @Override
    public final DoubleMatrix1D position()
    {
        return m_position;
    }

    @Override
    protected final Stream<ILiteral> individualliteral( final Stream<IObject<?>> p_object )
    {
        return Stream.empty();
    }

    @Override
    public final IVehicle call() throws Exception
    {
        super.call();

        // give environment the data if it is a user car
        if ( !m_environment.move( this ) )
            if ( m_userdefinied )
                m_environment.trigger( CTrigger.from( ITrigger.EType.ADDGOAL, CLiteral.from( "collision" ) ) );
            else
                this.trigger( CTrigger.from( ITrigger.EType.ADDGOAL, CLiteral.from( "collision" ) ) );

        System.out.println( m_position );
        CAnimation.CInstance.INSTANCE.vehicle( CAnimation.CInstance.EStatus.EXECUTE, this );
        return this;
    }

    /**
     * accelerate
     */
    @IAgentActionFilter
    @IAgentActionName( name = "accelerate" )
    private void accelerate()
    {
        if ( m_speed.get() + m_accelerate > m_maximumspeed )
            throw new RuntimeException( MessageFormat.format( "cannot increment speed: {0}", this ) );

        m_speed.addAndGet( m_accelerate + CUnit.INSTANCE.accelerationtospeed( m_accelerate ).doubleValue() );
    }

    /**
     * decelerate
     */
    @IAgentActionFilter
    @IAgentActionName( name = "decelerate" )
    private void decelerate()
    {
        if ( m_speed.get() - m_decelerate < 0 )
            throw new RuntimeException( MessageFormat.format( "cannot decrement speed: {0}", this ) );

        m_speed.set( m_speed.get() + CUnit.INSTANCE.accelerationtospeed( m_decelerate ).doubleValue() );
    }

    /**
     * swing-out
     */
    @IAgentActionFilter
    @IAgentActionName( name = "swingout" )
    private void swingout()
    {
    }

    /**
     * go back into lane
     */
    @IAgentActionFilter
    @IAgentActionName( name = "goback" )
    private void goback()
    {
    }

    @Override
    public final double speed()
    {
        return m_speed.get();
    }

    @Override
    public final IVehicle penalty( @Nonnull final Number p_value )
    {
        m_panelize.addAndGet( p_value.doubleValue() );
        return this;
    }

    @Override
    public final double penalty()
    {
        return m_panelize.get();
    }

    @Override
    public final boolean user()
    {
        return m_userdefinied;
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
         * user-definied vehicle
         */
        private final boolean m_userdefinied;
        /**
         * environment
         */
        private final IEnvironment m_environment;
        /**
         * random instance
         */
        private final Random m_random = new Random();


        /**
         * generator
         *
         * @param p_stream stream
         * @param p_environment environment reference
         * @param p_uiaccessiable generated cars are ui-accessable
         * @throws Exception on any error
         */
        public CGenerator( @Nonnull final InputStream p_stream, @Nonnull final IEnvironment p_environment,
                              final boolean p_uiaccessiable, final boolean p_userdefinied ) throws Exception
        {
            super( p_stream, CVehicle.class );
            m_visible = p_uiaccessiable;
            m_environment = p_environment;
            m_userdefinied = p_userdefinied;
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
        protected final Triple<IVehicle, Boolean, Stream<String>> generate( @Nullable final Object... p_data )
        {
            return new ImmutableTriple<>(
                new CVehicle(
                        m_configuration,
                        MessageFormat.format( "{0} {1}", FUNCTOR, COUNTER.getAndIncrement() ),
                        m_environment,
                        1,
                        1,
                        m_random.nextInt( 150 ) + 100,
                        m_userdefinied
                ),
                m_visible,
                Stream.of( "vehicle" )
            );
        }
    }
}
