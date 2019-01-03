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

package local.tiny.proof.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import local.tiny.proof.model.Fruit;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author paolo mococci
 */

public class FruitService 
        extends ListDataModel<Fruit> 
        implements SelectableDataModel<Fruit>, Serializable {

    public FruitService() {
        super();
    }
    
    public FruitService(List<Fruit> fruits) {
        super(fruits);
    }

    @Override
    public Object getRowKey(Fruit fruit) {
        return fruit.getId();
    }

    @Override
    public Fruit getRowData(String key) {
        List<Fruit> fruits = (List<Fruit>) getWrappedData();
        for(Fruit fruit : fruits) {
            if (fruit.getId() == Integer.parseInt(key)) {
                return fruit;
            }
        }
        return null;
    }
}
