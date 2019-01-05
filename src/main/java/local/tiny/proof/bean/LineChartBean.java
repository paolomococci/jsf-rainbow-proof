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
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.AccessLevel;
import lombok.Getter;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author paolo mococci
 */

@Named
@ViewScoped
public class LineChartBean 
        implements Serializable {
    
    @Getter(AccessLevel.PUBLIC)
    private LineChartModel lineChartModel;
    
    SecureRandom secureRandom = new SecureRandom();

    public LineChartBean() {
        super();
        createLineChartModel();
    }

    private void createLineChartModel() {
        lineChartModel = initLineChartModel();
        lineChartModel.setTitle("trend in bananas demand over the past fantasy year");
        lineChartModel.setLegendPosition("e");
        Axis x = lineChartModel.getAxis(AxisType.X);
        x.setLabel("months");
        x.setMin(1);
        x.setMax(12);
        x.setTickFormat("%.0f");
        Axis y = lineChartModel.getAxis(AxisType.Y);
        y.setLabel("tens of tons");
        y.setMin(0);
        y.setMax(500);
        y.setTickFormat("%.3f");
    }
    
    private LineChartModel initLineChartModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries fruits = new LineChartSeries();
        fruits.setLabel("bananas");
        fruits.set(1, secureRandomize());
        fruits.set(2, secureRandomize());
        fruits.set(3, secureRandomize());
        fruits.set(4, secureRandomize());
        fruits.set(5, secureRandomize());
        fruits.set(6, secureRandomize());
        fruits.set(7, secureRandomize());
        fruits.set(8, secureRandomize());
        fruits.set(9, secureRandomize());
        fruits.set(10, secureRandomize());
        fruits.set(11, secureRandomize());
        fruits.set(12, secureRandomize());
        model.addSeries(fruits);
        return model;
    }
    
    private int secureRandomize() {
        double temp = secureRandom.nextDouble();
        return (int) (temp * 490);
    }
}
