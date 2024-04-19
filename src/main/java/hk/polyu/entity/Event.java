package hk.polyu.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "BMS_EVENT", indexes = {
        @Index(name = "IDX_BMS_EVENT_CREATOR_TEACHER", columnList = "CREATOR_TEACHER_ID"),
        @Index(name = "IDX_BMS_EVENT_HOST_TEACHER", columnList = "HOST_TEACHER_ID"),
        @Index(name = "IDX_BMS_EVENT_SUBJECT", columnList = "SUBJECT_ID")
})
@Entity(name = "bms_Event")
public class Event {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OneToMany(mappedBy = "event")
    private List<EventStudentInvitee> studentInvitees;

    @Composition
    @OneToMany(mappedBy = "event")
    private List<TimeslotCluster> timeslotClusters;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "SUBJECT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CREATOR_TEACHER_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User creatorTeacher;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "HOST_TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User hostTeacher;

    @PositiveOrZero
    @NotNull
    @Column(name = "TIMESLOT_DURATION", nullable = false)
    private Integer timeslotDuration;

    @Column(name = "COOLDOWN_DURATION", nullable = false)
    @NotNull
    private Integer cooldownDuration;

    @PositiveOrZero
    @Column(name = "MINIMUM_TIMESLOT_SELECTION_COUNT", nullable = false)
    @NotNull
    private Integer minimumTimeslotPreferenceDeclarationCount;

    @Column(name = "TIMESLOT_PREFERENCE_DECLARATION_DEADLINE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeslotPreferenceDeclarationDeadline;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public List<EventStudentInvitee> getStudentInvitees() {
        return studentInvitees;
    }

    public void setStudentInvitees(List<EventStudentInvitee> studentInvitees) {
        this.studentInvitees = studentInvitees;
    }

    public Integer getCooldownDuration() {
        return cooldownDuration;
    }

    public void setCooldownDuration(Integer cooldownDuration) {
        this.cooldownDuration = cooldownDuration;
    }

    public List<TimeslotCluster> getTimeslotClusters() {
        return timeslotClusters;
    }

    public void setTimeslotClusters(List<TimeslotCluster> timeslotClusters) {
        this.timeslotClusters = timeslotClusters;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTimeslotDuration(Integer timeslotDuration) {
        this.timeslotDuration = timeslotDuration;
    }

    public Integer getTimeslotDuration() {
        return timeslotDuration;
    }

    public Date getTimeslotPreferenceDeclarationDeadline() {
        return timeslotPreferenceDeclarationDeadline;
    }

    public void setTimeslotPreferenceDeclarationDeadline(Date timeslotPreferenceDeclarationDeadline) {
        this.timeslotPreferenceDeclarationDeadline = timeslotPreferenceDeclarationDeadline;
    }

    public Integer getMinimumTimeslotPreferenceDeclarationCount() {
        return minimumTimeslotPreferenceDeclarationCount;
    }

    public void setMinimumTimeslotPreferenceDeclarationCount(Integer minimumTimeslotSelectionCount) {
        this.minimumTimeslotPreferenceDeclarationCount = minimumTimeslotSelectionCount;
    }

    public User getHostTeacher() {
        return hostTeacher;
    }

    public void setHostTeacher(User hostTeacher) {
        this.hostTeacher = hostTeacher;
    }

    public User getCreatorTeacher() {
        return creatorTeacher;
    }

    public void setCreatorTeacher(User creatorTeacher) {
        this.creatorTeacher = creatorTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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