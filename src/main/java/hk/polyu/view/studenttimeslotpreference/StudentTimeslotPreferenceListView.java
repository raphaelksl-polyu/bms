package hk.polyu.view.studenttimeslotpreference;

import hk.polyu.entity.StudentTimeslotPreference;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "studentTimeslotPreferences", layout = MainView.class)
@ViewController("bms_StudentTimeslotPreference.list")
@ViewDescriptor("student-timeslot-preference-list-view.xml")
@LookupComponent("studentTimeslotPreferencesDataGrid")
@DialogMode(width = "64em")
public class StudentTimeslotPreferenceListView extends StandardListView<StudentTimeslotPreference> {
}