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

package org.lightjason.trafficsimulation.elements.environment;

import cern.colt.matrix.tdouble.DoubleMatrix1D;
import org.lightjason.trafficsimulation.elements.IObject;
import org.lightjason.trafficsimulation.elements.vehicle.IVehicle;

import javax.annotation.Nonnull;
import java.util.stream.Stream;


/**
 * environment interface
 */
public interface IEnvironment extends IObject<IEnvironment>
{

    /**
     * sets avehicle inside the grid
     *
     * @param p_vehicle vehicle
     * @param p_position position
     * @return set can be done
     */
    boolean set( @Nonnull final IVehicle p_vehicle, @Nonnull final DoubleMatrix1D p_position );

    /**
     * moves a vehicle inside the environment
     *
     * @param p_vehicle vehicle
     * @return move can be done
     */
    boolean move( @Nonnull IVehicle p_vehicle );

    /**
     * lane changing of a vehicle
     *
     * @param p_vehicle vehicle
     * @param p_lane new lane
     * @return changing successful
     */
    boolean lanechange( @Nonnull IVehicle p_vehicle, final Number p_lane );

    /**
     * return an object stream
     * for each position
     *
     * @param p_position position stream
     * @return object stream
     */
    @Nonnull
    Stream<? extends IObject<?>> get( @Nonnull final Stream<DoubleMatrix1D> p_position );

    /**
     * clips the diven position to the environment structure
     *
     * @param p_position position
     * @return new vector with clipped position
     */
    @Nonnull
    DoubleMatrix1D clip( @Nonnull final DoubleMatrix1D p_position );

}
