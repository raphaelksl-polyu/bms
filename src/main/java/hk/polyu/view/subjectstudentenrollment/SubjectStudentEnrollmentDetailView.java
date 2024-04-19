package hk.polyu.view.subjectstudentenrollment;

import hk.polyu.entity.SubjectStudentEnrollment;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "subjectStudentEnrollments/:id", layout = MainView.class)
@ViewController("bms_SubjectStudentEnrollment.detail")
@ViewDescriptor("subject-student-enrollment-detail-view.xml")
@EditedEntityContainer("subjectStudentEnrollmentDc")
public class SubjectStudentEnrollmentDetailView extends StandardDetailView<SubjectStudentEnrollment> {
}