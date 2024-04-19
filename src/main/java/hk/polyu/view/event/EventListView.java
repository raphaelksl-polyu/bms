package hk.polyu.view.event;

import hk.polyu.entity.Event;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "events", layout = MainView.class)
@ViewController("bms_Event.list")
@ViewDescriptor("event-list-view.xml")
@LookupComponent("eventsDataGrid")
@DialogMode(width = "64em")
public class EventListView extends StandardListView<Event> {
}