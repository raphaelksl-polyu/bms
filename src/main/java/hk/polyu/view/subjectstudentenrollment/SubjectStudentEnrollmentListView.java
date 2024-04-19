package hk.polyu.view.subjectstudentenrollment;

import hk.polyu.entity.SubjectStudentEnrollment;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "subjectStudentEnrollments", layout = MainView.class)
@ViewController("bms_SubjectStudentEnrollment.list")
@ViewDescriptor("subject-student-enrollment-list-view.xml")
@LookupComponent("subjectStudentEnrollmentsDataGrid")
@DialogMode(width = "64em")
public class SubjectStudentEnrollmentListView extends StandardListView<SubjectStudentEnrollment> {
}