package hk.polyu.view.subject;

import hk.polyu.entity.Subject;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "subjects", layout = MainView.class)
@ViewController("bms_Subject.list")
@ViewDescriptor("subject-list-view.xml")
@LookupComponent("subjectsDataGrid")
@DialogMode(width = "64em")
public class SubjectListView extends StandardListView<Subject> {
}