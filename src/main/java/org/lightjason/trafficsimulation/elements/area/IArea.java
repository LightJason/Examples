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

package org.lightjason.trafficsimulation.elements.area;

import cern.colt.matrix.tdouble.DoubleMatrix1D;
import org.lightjason.trafficsimulation.elements.IObject;
import org.lightjason.trafficsimulation.elements.vehicle.IVehicle;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;


/**
 * area interface
 */
public interface IArea extends IObject<IArea>
{

    /**
     * adds an object to the area
     *
     * @param p_object object
     * @return input object
     */
    IVehicle push( @Nonnull IVehicle p_object, @Nonnull DoubleMatrix1D p_start, @Nonnull DoubleMatrix1D p_end, @Nonnull @Nonnegative Number p_speed );

    /**
     * returns the allowed speed in km/h
     *
     * @return allowed speed
     */
    @Nonnegative
    double allowedspeed();

    /**
     * length / width of the area in km
     *
     * @return length
     */
    @Nonnegative
    double length();

}
