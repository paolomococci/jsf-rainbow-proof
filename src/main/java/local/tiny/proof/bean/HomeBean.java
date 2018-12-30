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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author paolo mococci
 */

@Named
public class HomeBean {
    
    public void create() {
        infoMessage("Ok, right now I should create a new record in the database.", 
                "Functionality to do implement!");
    }
    
    public void read() {
        infoMessage("Ok, by providing me with an identifier I should read a record in the database.", 
                "Functionality to do implement!");
    }
    
    public void update() {
        warnMessage("Ok, by providing me with an identifier I should update a record in the database.", 
                "Functionality to do implement!");
    }
    
    public void delete() {
        warnMessage("Ok, by providing me with an identifier I should delete a record in the database.", 
                "Functionality to do implement!");
    }
    
    private void warnMessage(String summary, String detail) {
        FacesMessage facesMessage;
        facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    private void infoMessage(String summary, String detail) {
        FacesMessage facesMessage;
        facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
