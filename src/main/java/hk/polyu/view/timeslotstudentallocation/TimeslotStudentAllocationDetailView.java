package hk.polyu.view.timeslotstudentallocation;

import hk.polyu.entity.TimeslotStudentAllocation;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "timeslotStudentAllocations/:id", layout = MainView.class)
@ViewController("bms_TimeslotStudentAllocation.detail")
@ViewDescriptor("timeslot-student-allocation-detail-view.xml")
@EditedEntityContainer("timeslotStudentAllocationDc")
public class TimeslotStudentAllocationDetailView extends StandardDetailView<TimeslotStudentAllocation> {
}