/*
 * Copyright (C) 2017. Kryptnostic, Inc (dba Loom)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact the owner of the copyright at support@thedataloom.com
 */

package com.dataloom.neuron.pods;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.dataloom.neuron.configuration.WebSocketConfig;
import com.dataloom.neuron.controllers.NeuronController;
import com.dataloom.neuron.synapses.NotificationsSynapse;

@Configuration
@ComponentScan(
        basePackageClasses = {
                NeuronController.class,
                NotificationsSynapse.class
        },
        includeFilters = @ComponentScan.Filter(
                value = {
                        org.springframework.stereotype.Component.class,
                        org.springframework.stereotype.Controller.class
                },
                type = FilterType.ANNOTATION
        )
)
@Import( WebSocketConfig.class )
public class NeuronMvcPod extends WebMvcConfigurationSupport {}