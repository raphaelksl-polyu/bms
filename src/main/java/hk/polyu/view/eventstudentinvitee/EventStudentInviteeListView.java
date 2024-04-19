package hk.polyu.view.eventstudentinvitee;

import hk.polyu.entity.EventStudentInvitee;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "eventStudentInvitees", layout = MainView.class)
@ViewController("bms_EventStudentInvitee.list")
@ViewDescriptor("event-student-invitee-list-view.xml")
@LookupComponent("eventStudentInviteesDataGrid")
@DialogMode(width = "64em")
public class EventStudentInviteeListView extends StandardListView<EventStudentInvitee> {
}