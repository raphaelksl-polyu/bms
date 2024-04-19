package hk.polyu.view.studenttimeslotpreference;

import hk.polyu.entity.StudentTimeslotPreference;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "studentTimeslotPreferences/:id", layout = MainView.class)
@ViewController("bms_StudentTimeslotPreference.detail")
@ViewDescriptor("student-timeslot-preference-detail-view.xml")
@EditedEntityContainer("studentTimeslotPreferenceDc")
public class StudentTimeslotPreferenceDetailView extends StandardDetailView<StudentTimeslotPreference> {
}