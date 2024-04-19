package hk.polyu.view.generatedtimeslot;

import hk.polyu.entity.GeneratedTimeslot;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "generatedTimeslots", layout = MainView.class)
@ViewController("bms_GeneratedTimeslot.list")
@ViewDescriptor("generated-timeslot-list-view.xml")
@LookupComponent("generatedTimeslotsDataGrid")
@DialogMode(width = "64em")
public class GeneratedTimeslotListView extends StandardListView<GeneratedTimeslot> {
}