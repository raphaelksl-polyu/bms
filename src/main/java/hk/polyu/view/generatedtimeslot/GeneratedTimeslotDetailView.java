package hk.polyu.view.generatedtimeslot;

import hk.polyu.entity.GeneratedTimeslot;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "generatedTimeslots/:id", layout = MainView.class)
@ViewController("bms_GeneratedTimeslot.detail")
@ViewDescriptor("generated-timeslot-detail-view.xml")
@EditedEntityContainer("generatedTimeslotDc")
public class GeneratedTimeslotDetailView extends StandardDetailView<GeneratedTimeslot> {
}