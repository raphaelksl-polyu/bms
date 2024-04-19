package hk.polyu.view.eventstudentinvitee;

import hk.polyu.entity.EventStudentInvitee;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "eventStudentInvitees/:id", layout = MainView.class)
@ViewController("bms_EventStudentInvitee.detail")
@ViewDescriptor("event-student-invitee-detail-view.xml")
@EditedEntityContainer("eventStudentInviteeDc")
public class EventStudentInviteeDetailView extends StandardDetailView<EventStudentInvitee> {
}