/*
 * @cond LICENSE
 * ######################################################################################
 * # LGPL License                                                                       #
 * #                                                                                    #
 * # This file is part of the LightJason                                                #
 * # Copyright (c) 2015-16, LightJason (info@lightjason.org)                            #
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


// initial-goal
!main.



// initial plan (triggered by the initial goal)
+!main <-
    generic/print("Hello World! on", MyName);
    !mynextgoal
.



// plan with is run every cycle
+!mynextgoal <-
    generic/print( "Hello World! (again)", Cycle, "on agent", MyName );
    !mynextgoal
.


/**
 * trigger-plan which is called by the trigger
 *
 * @param X any value which is pushed by the trigger call
 */
+!special-goal(X) <-
    generic/print( "special goal with value", X, "triggered in cycle", Cycle, "on agent", MyName );

    R = my/standalone-action( "Lorem Ipsum" );
    generic/print("return of my standalone action is", R, "on agent", MyName );

    my/inner-action( 4711 )
.
