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

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import local.tiny.proof.model.Fruit;
import lombok.AccessLevel;
import lombok.Getter;

/**
 *
 * @author paolo mococci
 */

@Named
public class FruitBean {
    
    @Getter(AccessLevel.PUBLIC)
    private final List<Fruit> fruits;

    public FruitBean() {
        fruits = new ArrayList<>();
        fruits.add(new Fruit(1, "cherry", "red", "sweet"));
        fruits.add(new Fruit(2, "strawberry", "red", "sweet"));
        fruits.add(new Fruit(3, "lemon", "yellow", "sour"));
        fruits.add(new Fruit(4, "melon", "yellow", "sweet"));
        fruits.add(new Fruit(5, "grapes", "green", "sour"));
    }
}
