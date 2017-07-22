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

package org.lightjason.trafficsimulation.runtime;

import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import org.apache.commons.io.IOUtils;
import org.lightjason.trafficsimulation.common.CCommon;
import org.lightjason.trafficsimulation.common.CConfiguration;
import org.lightjason.trafficsimulation.elements.environment.CEnvironment;
import org.lightjason.trafficsimulation.elements.environment.IEnvironment;
import org.lightjason.trafficsimulation.elements.vehicle.CVehicle;
import org.lightjason.trafficsimulation.elements.vehicle.IVehicle;
import org.lightjason.trafficsimulation.ui.api.CMessage;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * runtime task instance
 */
public class CTask implements ITask
{
    /**
     * logger
     */
    private static final Logger LOGGER = CCommon.logger( ITask.class );
    /**
     * simulation speed
     */
    private final int m_simulationspeed = CConfiguration.INSTANCE.getOrDefault( 100, "main", "simulationspeed" );
    /**
     * thread
     */
    private final Thread m_thread;

    /**
     * ctor
     *
     * @param p_asl asl map
     */
    public CTask( @Nonnull final Map<String, String> p_asl )
    {
        m_thread = new Thread( () ->
        {
            final IEnvironment l_environment;

            try
            {
                l_environment = new CEnvironment.CGenerator( Collections.unmodifiableMap( p_asl ) ).generatesingle();
            }
            catch ( final Exception l_exception )
            {
                CMessage.CInstance.INSTANCE.write(
                    CMessage.EType.ERROR,
                    CCommon.languagestring( this, "environment" ),
                    l_exception.getLocalizedMessage()
                );
                return;
            }

            if ( l_environment == null )
            {
                LOGGER.warning( "environment cannot be instantiable" );
                return;
            }

            // execute objects
            CMessage.CInstance.INSTANCE.write(
                CMessage.EType.SUCCESS,
                CCommon.languagestring( this, "environment" ),
                CCommon.languagestring( this, "simulationstart" )
            );

            // environment loop
            final Set<Callable<?>> l_elements = Stream.of( l_environment ).collect( Collectors.toSet() );

            // ---- @todo test ------
            try
            {
                final IVehicle l_vehicle = new CVehicle.CGenerator( IOUtils.toInputStream( p_asl.get( "defaultvehicle" ), "UTF-8" ), l_environment, true, false )
                    .generatesingle();
                l_elements.add( l_vehicle );
                l_environment.set( l_vehicle, new DenseDoubleMatrix1D( new double[]{0, 1} ) );
            }
            catch ( final Exception l_exception )
            {
            }
            // ----------------------

            while ( !l_environment.shutdown() )
            {
                l_elements.parallelStream().forEach( CTask::execute );
                try
                {
                    Thread.sleep( m_simulationspeed );
                }
                catch ( final InterruptedException l_exception )
                {
                    break;
                }
            }

            CMessage.CInstance.INSTANCE.write(
                CMessage.EType.SUCCESS,
                CCommon.languagestring( this, "environment" ),
                CCommon.languagestring( this, "simulationstop" )
            );
        } );
    }


    /**
     * execute any object
     *
     * @param p_object callable
     */
    private static void execute( @Nonnull final Callable<?> p_object )
    {
        try
        {
            p_object.call();
        }
        catch ( final Exception l_execution )
        {
            LOGGER.warning( l_execution.getLocalizedMessage() );
        }
    }


    @Override
    public final ITask call() throws Exception
    {
        if ( ( !m_thread.isAlive() ) && ( !m_thread.isInterrupted() ) )
            m_thread.start();

        return this;
    }

    @Override
    public final boolean running()
    {
        return m_thread.isAlive();
    }
}
