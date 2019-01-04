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

package local.tiny.proof.bean;

import java.io.Serializable;
import java.security.SecureRandom;
import javax.inject.Named;
import lombok.AccessLevel;
import lombok.Getter;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author paolo mococci
 */

@Named
public class BarChartBean 
        implements Serializable {
    
    @Getter(AccessLevel.PUBLIC)
    private BarChartModel barChartModel;
    
    SecureRandom secureRandom = new SecureRandom();

    public BarChartBean() {
        super();
        this.createBarChartModel();
    }

    private void createBarChartModel() {
        barChartModel = initBarChartModel();
        barChartModel.setTitle("fruits harvested during a fantasy year");
        barChartModel.setLegendPosition("ne");
        Axis x = barChartModel.getAxis(AxisType.X);
        x.setLabel("fruits");
        Axis y = barChartModel.getAxis(AxisType.Y);
        y.setLabel("thousands of tons");
        y.setMin(0);
        y.setMax(500);
    }
    
    private BarChartModel initBarChartModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries fruits = new BarChartSeries();
        fruits.setLabel("fruits");
        fruits.set("almond", this.secureRandomize());
        fruits.set("apple", this.secureRandomize());
        fruits.set("apricot", this.secureRandomize());
        fruits.set("banana", this.secureRandomize());
        fruits.set("breadfruit", this.secureRandomize());
        fruits.set("cherry", this.secureRandomize());
        fruits.set("grapes", this.secureRandomize());
        fruits.set("lemon", this.secureRandomize());
        fruits.set("melon", this.secureRandomize());
        fruits.set("orange", this.secureRandomize());
        fruits.set("persimmon", this.secureRandomize());
        fruits.set("strawberry", this.secureRandomize());
        fruits.set("watermelon", this.secureRandomize());
        model.addSeries(fruits);
        return model;
    }
    
    private int secureRandomize() {
        double temp = this.secureRandom.nextDouble();
        return (int) (temp * 490);
    }
}
