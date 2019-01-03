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

package local.tiny.proof.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author paolo mococci
 */

@Data
public class Fruit 
        implements Serializable {
    
    private int id;
    private String name;
    private String color;
    private String taste;

    public Fruit() {
        super();
    }

    public Fruit(int id, String name, String color, String taste) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.taste = taste;
    }

    public Fruit(int id, String name, String color, String taste, double price) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.taste = taste;
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Fruit other = (Fruit) object;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return Objects.equals(this.taste, other.taste);
    }
}
