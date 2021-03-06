/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.tiny.proof.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author paolo mococci
 */

@Configuration
public class WebConf 
        implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/home.xhtml");
        registry.addViewController("/home").setViewName("forward:/home.xhtml");
        registry.addViewController("/input-mask").setViewName("forward:/input-mask.xhtml");
        registry.addViewController("/input-inplace").setViewName("forward:/input-inplace.xhtml");
        registry.addViewController("/accordion-panel").setViewName("forward:/accordion-panel.xhtml");
        registry.addViewController("/tab-view").setViewName("forward:/tab-view.xhtml");
        registry.addViewController("/wizard").setViewName("forward:/wizard.xhtml");
        registry.addViewController("/data-list").setViewName("forward:/data-list.xhtml");
        registry.addViewController("/table").setViewName("forward:/table.xhtml");
        registry.addViewController("/table-with-highlighted-lines").setViewName("forward:/table-with-highlighted-lines.xhtml");
        registry.addViewController("/table-with-filterable-values").setViewName("forward:/table-with-filterable-values.xhtml");
        registry.addViewController("/table-with-right-align-values").setViewName("forward:/table-with-right-align-values.xhtml");
        registry.addViewController("/table-toggle").setViewName("forward:/table-toggle.xhtml");
        registry.addViewController("/table-with-sortable-values").setViewName("forward:/table-with-sortable-values.xhtml");
        registry.addViewController("/bar-chart").setViewName("forward:/bar-chart.xhtml");
        registry.addViewController("/line-chart").setViewName("forward:/line-chart.xhtml");
        registry.addViewController("/candlestick-chart").setViewName("forward:/candlestick-chart.xhtml");
        registry.addViewController("/planning-chart").setViewName("forward:/planning-chart.xhtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
