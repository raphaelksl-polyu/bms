package hk.polyu.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

@JmixEntity
@Table(name = "BMS_STUDENT_TIMESLOT_PREFERENCE", indexes = {
        @Index(name = "IDX_BMS_STUDENT_TIMESLOT_PREFERENCE_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_BMS_STUDENT_TIMESLOT_PREFERENCE_GENERATED_TIMESLOT", columnList = "GENERATED_TIMESLOT_ID")
})
@Entity(name = "bms_StudentTimeslotPreference")
public class StudentTimeslotPreference {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User student;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "GENERATED_TIMESLOT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private GeneratedTimeslot generatedTimeslot;

    @Positive
    @Column(name = "PREFERENCE_RANKING", nullable = false)
    @NotNull
    private Integer preferenceRanking;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public Integer getPreferenceRanking() {
        return preferenceRanking;
    }

    public void setPreferenceRanking(Integer preferenceRanking) {
        this.preferenceRanking = preferenceRanking;
    }

    public GeneratedTimeslot getGeneratedTimeslot() {
        return generatedTimeslot;
    }

    public void setGeneratedTimeslot(GeneratedTimeslot generatedTimeslot) {
        this.generatedTimeslot = generatedTimeslot;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
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