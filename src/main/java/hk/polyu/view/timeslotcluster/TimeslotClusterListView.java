package hk.polyu.view.timeslotcluster;

import hk.polyu.entity.TimeslotCluster;

import hk.polyu.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "timeslotClusters", layout = MainView.class)
@ViewController("bms_TimeslotCluster.list")
@ViewDescriptor("timeslot-cluster-list-view.xml")
@LookupComponent("timeslotClustersDataGrid")
@DialogMode(width = "64em")
public class TimeslotClusterListView extends StandardListView<TimeslotCluster> {
}