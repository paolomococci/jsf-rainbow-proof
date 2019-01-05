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
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

/**
 *
 * @author paolo mococci
 */

@Named
@ViewScoped
public class CandlestickChartBean 
        implements Serializable {
    
    @Getter(AccessLevel.PUBLIC)
    private OhlcChartModel candlestickChartModel;
    
    SecureRandom secureRandom = new SecureRandom();

    public CandlestickChartBean() {
        super();
        this.createCandlestickChartModel();
    }

    private void createCandlestickChartModel() {
        candlestickChartModel = initCandlestickChartModel();
        candlestickChartModel.setTitle("trend of values in the last fantasy month");
        candlestickChartModel.setCandleStick(true);
        candlestickChartModel.getAxis(AxisType.X).setLabel("days");
        candlestickChartModel.getAxis(AxisType.X).setMin(0);
        candlestickChartModel.getAxis(AxisType.X).setMax(32);
        candlestickChartModel.getAxis(AxisType.X).setTickFormat("%.0f");
        candlestickChartModel.getAxis(AxisType.Y).setLabel("values");
    }
    
    private OhlcChartModel initCandlestickChartModel() {
        OhlcChartModel model = new OhlcChartModel();
        for (int i = 1; i <= 31; i++) {
            model.add(new OhlcChartSeries(
                    i, 
                    secureRandomize(80, 80), 
                    secureRandomize(80, 160), 
                    secureRandomize(80, 0), 
                    secureRandomize(80, 80)
            ));
        }
        return model;
    }
    
    private int secureRandomize(int value, int offsetting) {
        double temp = secureRandom.nextDouble();
        return (int) (temp * value) + offsetting;
    }
}
