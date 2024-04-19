package hk.polyu.view.subject;

import hk.polyu.entity.Subject;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "subjects/:id", layout = MainView.class)
@ViewController("bms_Subject.detail")
@ViewDescriptor("subject-detail-view.xml")
@EditedEntityContainer("subjectDc")
public class SubjectDetailView extends StandardDetailView<Subject> {
}