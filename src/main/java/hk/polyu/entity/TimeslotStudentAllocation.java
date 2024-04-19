package hk.polyu.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "BMS_TIMESLOT_STUDENT_ALLOCATION", indexes = {
        @Index(name = "IDX_BMS_TIMESLOT_STUDENT_ALLOCATION_GENERATED_TIMESLOT", columnList = "GENERATED_TIMESLOT_ID"),
        @Index(name = "IDX_BMS_TIMESLOT_STUDENT_ALLOCATION_STUDENT", columnList = "STUDENT_ID")
})
@Entity(name = "bms_TimeslotStudentAllocation")
public class TimeslotStudentAllocation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "GENERATED_TIMESLOT_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private GeneratedTimeslot generatedTimeslot;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User student;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public GeneratedTimeslot getGeneratedTimeslot() {
        return generatedTimeslot;
    }

    public void setGeneratedTimeslot(GeneratedTimeslot generatedTimeslot) {
        this.generatedTimeslot = generatedTimeslot;
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