package hk.polyu.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "BMS_GENERATED_TIMESLOT", indexes = {
        @Index(name = "IDX_BMS_GENERATED_TIMESLOT_TIMESLOT_CLUSTER", columnList = "TIMESLOT_CLUSTER_ID")
})
@Entity(name = "bms_GeneratedTimeslot")
public class GeneratedTimeslot {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "TIMESLOT_CLUSTER_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private TimeslotCluster timeslotCluster;

    @Column(name = "START_DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date startDatetime;

    @Column(name = "END_DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date endDatetime;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "generatedTimeslot")
    private TimeslotStudentAllocation timeslotStudentAllocation;

    public TimeslotStudentAllocation getTimeslotStudentAllocation() {
        return timeslotStudentAllocation;
    }

    public void setTimeslotStudentAllocation(TimeslotStudentAllocation timeslotStudentAllocation) {
        this.timeslotStudentAllocation = timeslotStudentAllocation;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public TimeslotCluster getTimeslotCluster() {
        return timeslotCluster;
    }

    public void setTimeslotCluster(TimeslotCluster timeslotCluster) {
        this.timeslotCluster = timeslotCluster;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}