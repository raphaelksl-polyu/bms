package hk.polyu.view.timeslotcluster;

import hk.polyu.entity.TimeslotCluster;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "timeslotClusters/:id", layout = MainView.class)
@ViewController("bms_TimeslotCluster.detail")
@ViewDescriptor("timeslot-cluster-detail-view.xml")
@EditedEntityContainer("timeslotClusterDc")
public class TimeslotClusterDetailView extends StandardDetailView<TimeslotCluster> {
}