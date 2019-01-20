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

package local.tiny.proof.view;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import local.tiny.proof.model.Fruit;
import local.tiny.proof.service.RandomListOfFruitsService;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author paolo mococci
 */

@Named
@ViewScoped
public class DataTableFilterView 
        implements Serializable {
    
    @Getter
    @Setter
    private List<Fruit> fruits;
    
    @Getter
    @Setter
    private List<Fruit> filteredFruits;
    
    @Setter
    private RandomListOfFruitsService randomListOfFruitsService;

    public DataTableFilterView() {
        super();
        randomListOfFruitsService = new RandomListOfFruitsService();
        fruits = randomListOfFruitsService.initialize(10);
    }
    
    public List<String> getNames() {
        return randomListOfFruitsService.getNames();
    }
    
    public List<String> getColors() {
        return randomListOfFruitsService.getColors();
    }
    
    public List<String> getTastes() {
        return randomListOfFruitsService.getTastes();
    }
}
