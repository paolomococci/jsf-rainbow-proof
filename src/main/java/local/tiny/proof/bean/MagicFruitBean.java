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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import local.tiny.proof.model.Fruit;
import lombok.AccessLevel;
import lombok.Getter;

/**
 *
 * @author paolo mococci
 */

@Named
@ViewScoped
public class MagicFruitBean 
        implements Serializable {
    
    private final static String[] colors;
    private final static String[] names;
    private final static String[] tastes;
    
    static {
        colors = new String[10];
        colors[0] = "white";
        colors[1] = "yellow";
        colors[2] = "green";
        colors[3] = "red";
        colors[4] = "brown";
        colors[5] = "maroon";
        colors[6] = "orange";
        colors[7] = "khaki";
        colors[8] = "blue";
        colors[9] = "black";
        
        names = new String[10];
        names[0] = "cherry";
        names[1] = "strawberry";
        names[2] = "lemon";
        names[3] = "melon";
        names[4] = "grapes";
        names[5] = "almond";
        names[6] = "apple";
        names[7] = "banana";
        names[8] = "breadfruit";
        names[9] = "persimmon";
        
        tastes = new String[10];
        tastes[0] = "bitter";
        tastes[1] = "sour";
        tastes[2] = "sweet";
        tastes[3] = "salty";
        tastes[4] = "umami";
        tastes[5] = "fried";
        tastes[6] = "fat";
        tastes[7] = "fermented";
        tastes[8] = "spicy";
        tastes[9] = "fresh";
    }
    
    @Getter(AccessLevel.PUBLIC)
    private final List<Fruit> fruits;

    public MagicFruitBean() {
        super();
        this.fruits = new ArrayList<>();
        this.populate(fruits, 10);
    }

    public MagicFruitBean(List<Fruit> fruits) {
        super();
        this.fruits = fruits;
    }
    
    private void populate(List<Fruit> fruits, int size) {
        for (int i = 0; i < size; i++) {
            fruits.add(new Fruit(
                    this.randomizeId(), 
                    this.randomizeName(), 
                    this.randomizeColor(), 
                    this.randomizeTaste(), 
                    this.randomizePrice()
            ));
        }
    }
    
    private int randomizeId() {
        return (int) (Math.random() * 10);
    }
    
    private String randomizeName() {
        return names[(int) (Math.random() * 10)];
    }
    
    private String randomizeColor() {
        return colors[(int) (Math.random() * 10)];
    }
    
    private String randomizeTaste() {
        return tastes[(int) (Math.random() * 10)];
    }
    
    private double randomizePrice() {
        double temp = (Math.random() * 5D);
        return BigDecimal.valueOf(temp)
                .setScale(2, RoundingMode.CEILING)
                .doubleValue();
    }
}
