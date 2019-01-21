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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import local.tiny.proof.model.Customer;
import lombok.Data;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author paolo mococci
 */

@Named
@ViewScoped
@Data
public class CustomerWizardBean 
        implements Serializable {
    
    private Customer customer;
    private boolean leap;

    public CustomerWizardBean() {
        super();
        this.customer = new Customer();
    }
    
    public void commit() {
        FacesMessage facesMessage = new FacesMessage(
                FacesMessage.SEVERITY_INFO, 
                "Ok!", 
                "Welcome " + customer.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public String onFlowProcess(FlowEvent flowEvent) {
        if (leap) {
            leap = false;
            return "confirm";
        }
        return flowEvent.getNewStep();
    }
}
