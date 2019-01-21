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
public class Customer 
        implements Serializable {
    
    private String firstname;
    private String lastname;
    private String birthday;
    private String state;
    private String city;
    private String street;
    private String civic;
    private String zip;
    private String email;
    private String phone;
    private String info;

    public Customer() {
        super();
        this.state = "none";
        this.city = "none";
        this.street = "none";
        this.civic = "none";
        this.zip = "none";
        this.email = "none";
        this.phone = "none";
        this.info = "none";
    }
}
