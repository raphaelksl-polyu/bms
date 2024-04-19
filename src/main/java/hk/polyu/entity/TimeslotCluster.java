package hk.polyu.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "BMS_TIMESLOT_CLUSTER")
@Entity(name = "bms_TimeslotCluster")
public class TimeslotCluster {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OrderBy("startDatetime")
    @OneToMany(mappedBy = "timeslotCluster")
    private List<GeneratedTimeslot> generatedTimeslot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EVENT_ID", nullable = false)
    @NotNull
    private Event event;

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

    public List<GeneratedTimeslot> getGeneratedTimeslot() {
        return generatedTimeslot;
    }

    public void setGeneratedTimeslot(List<GeneratedTimeslot> generatedTimeslot) {
        this.generatedTimeslot = generatedTimeslot;
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

    public void setStartDatetime(Date startDatettime) {
        this.startDatetime = startDatettime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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