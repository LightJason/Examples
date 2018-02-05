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

package myagentproject;

import org.lightjason.agentspeak.common.CCommon;
import org.lightjason.agentspeak.generator.IBaseAgentGenerator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.InputStream;
import java.util.stream.Collectors;


/**
 * agent generator to create agents
 */
final class MyAgentGenerator extends IBaseAgentGenerator<MyAgent>
{
    /**
     * @param p_stream ASL code as any stream e.g. FileInputStream
     */
    MyAgentGenerator( @Nonnull final InputStream p_stream ) throws Exception
    {
        super(
            // input ASL stream
            p_stream,

            // we use all built-in actions of LightJason
            CCommon.actionsFromPackage().collect( Collectors.toSet() ),

            // variable builder for agent name
            new CVariableBuilder()
        );
    }

    /**
     * generator method of the agent
     *
     * @param p_data any data which can be put from outside to the generator method
     * @return returns an agent
     */
    @Nullable
    @Override
    public final MyAgent generatesingle( @Nullable final Object... p_data )
    {
        return new MyAgent( m_configuration );
    }
}
