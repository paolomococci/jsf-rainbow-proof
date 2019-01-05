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
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.AccessLevel;
import lombok.Getter;
import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

/**
 *
 * @author paolo mococci
 */

@Named
@ViewScoped
@Getter(AccessLevel.PUBLIC)
public class PlanningBean 
        implements Serializable {
    
    private final TimelineModel planning;
    private final Calendar calendar;
    private final boolean selectable = true;
    private final boolean zoomable = true;
    private final boolean moveable = true;
    private final boolean stackEvents = true;
    private final boolean showCurrentTime = true;
    private final boolean showNavigation = false;
    private boolean axisOnTop;
    private final String eventStyle = "box";

    public PlanningBean() {
        super();
        planning = new TimelineModel();
        calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY, 7, 6, 0);
        planning.add(createWorkOrder("WO201453", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 8, 30);
        planning.add(createWorkOrder("WO201463", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 11, 15);
        planning.add(createWorkOrder("WO201474", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 14, 0);
        planning.add(createWorkOrder("WO201483", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 17, 30);
        planning.add(createWorkOrder("WO201500", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 20, 0);
        planning.add(createWorkOrder("WO201518", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 22, 45);
        planning.add(createWorkOrder("WO201530", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 7, 23, 50);
        planning.add(createWorkOrder("WO201603", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 8, 3, 0);
        planning.add(createWorkOrder("WO201635", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 8, 5, 30);
        planning.add(createWorkOrder("WO201675", calendar.getTime()));
        calendar.set(2019, Calendar.JANUARY, 8, 11, 0);
        planning.add(createWorkOrder("WO201701", calendar.getTime()));
    }
    
    public void onSelect(TimelineSelectEvent event) {
        TimelineEvent timelineEvent = event.getTimelineEvent();
        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_WARN, 
                "You have selected: ", 
                timelineEvent.getData().toString());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private TimelineEvent createWorkOrder(String workOrder, Date start) {
        return new TimelineEvent(workOrder, start);
    }
}
