package hk.polyu.view.timeslotstudentallocation;

import hk.polyu.entity.TimeslotStudentAllocation;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "timeslotStudentAllocations", layout = MainView.class)
@ViewController("bms_TimeslotStudentAllocation.list")
@ViewDescriptor("timeslot-student-allocation-list-view.xml")
@LookupComponent("timeslotStudentAllocationsDataGrid")
@DialogMode(width = "64em")
public class TimeslotStudentAllocationListView extends StandardListView<TimeslotStudentAllocation> {
}