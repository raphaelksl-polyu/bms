package hk.polyu.view.event;

import hk.polyu.entity.Event;

import hk.polyu.entity.GeneratedTimeslot;
import hk.polyu.entity.TimeslotCluster;
import hk.polyu.entity.User;
import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Route(value = "events/:id", layout = MainView.class)
@ViewController("bms_Event.detail")
@ViewDescriptor("event-detail-view.xml")
@EditedEntityContainer("eventDc")
public class EventDetailView extends StandardDetailView<Event> {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DataManager dataManager;
    @ViewComponent
    private CollectionContainer<TimeslotCluster> timeslotClustersDc;


    /**
     * Runs code when entity is being created when the detail view is brought up.
     * Autofills the creator teacher field with logged-in user.
     * @param event Jmix UI interaction event (Not BMS meeting event)
     */
    @Subscribe
    public void onInitEntity(final InitEntityEvent<Event> event) {

        event.getEntity().setCreatorTeacher((User) currentAuthentication.getAuthentication().getPrincipal());

    }

    /**
     * Runs code when the [Generate timeslots] button is clicked
     * Loops through the meeting event's timeslot clusters
     * Removed all pre-existing generated timeslots and
     * Generated new timeslots according to the
     *  1. Event specified timeslot and cooldown duration
     *  2. Timeslot cluster specified start and end datetimes
     * @param event  Jmix UI interaction event (Not BMS meeting event)
     */
    @Subscribe("timeslotClustersDataGrid.generateTimeslots")
    public void onTimeslotClustersDataGridGenerateTimeslots(final ActionPerformedEvent event) {
        Event editedEntity = getEditedEntity();
        Calendar calendar = Calendar.getInstance();

        int timeslotDuration = editedEntity.getTimeslotDuration();
        int cooldownDuration = editedEntity.getCooldownDuration();

        for (TimeslotCluster timeslotCluster : timeslotClustersDc.getItems()) {

            // Removing pre-existing generated timeslots of timeslot cluster
            List<GeneratedTimeslot> existingTimeslots =
                    dataManager.load(GeneratedTimeslot.class)
                            .query("select gt from bms_GeneratedTimeslot gt " +
                                    "WHERE gt.timeslotCluster = :timeslotCluster")
                            .parameter("timeslotCluster",timeslotCluster)
                            .list();
            dataManager.remove(existingTimeslots);

            // Generating new timeslots of timeslot cluster
            Date clusterStartDatetime = timeslotCluster.getStartDatetime();
            Date clusterEndDatetime = timeslotCluster.getEndDatetime();
            Date timeslotStartDatetime = clusterStartDatetime;

            while (timeslotStartDatetime.before(clusterEndDatetime)) {
                calendar.clear();
                calendar.setTime(timeslotStartDatetime);
                calendar.add(Calendar.MINUTE, timeslotDuration);
                Date timeslotEndDatetime = calendar.getTime();

                if (timeslotEndDatetime.before(clusterEndDatetime) | timeslotEndDatetime.equals(clusterEndDatetime)) {

                    GeneratedTimeslot generatedTimeslot = dataManager.create(GeneratedTimeslot.class);
                    generatedTimeslot.setTimeslotCluster(timeslotCluster);
                    generatedTimeslot.setStartDatetime(timeslotStartDatetime);
                    generatedTimeslot.setEndDatetime(timeslotEndDatetime);
                    dataManager.save(generatedTimeslot);

                    calendar.add(Calendar.MINUTE, cooldownDuration);
                    timeslotStartDatetime = calendar.getTime();
                }



            }

        }


    }


}