package com.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.edu.domain.enumeration.Status;

/**
 * A Classroom.
 */
@Entity
@Table(name = "classroom")
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "mod_date")
    private Instant modDate;

    @Column(name = "actual_date")
    private Integer actualDate;

    @Column(name = "actual_duration")
    private Integer actualDuration;

    @Column(name = "sudent_present")
    private Integer sudentPresent;

    @OneToMany(mappedBy = "classroomId")
    @JsonIgnore
    private Set<ClassLog> classLogIds = new HashSet<>();

    @ManyToOne
    private Schedule scheduleId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public Classroom status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Classroom createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Classroom modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Integer getActualDate() {
        return actualDate;
    }

    public Classroom actualDate(Integer actualDate) {
        this.actualDate = actualDate;
        return this;
    }

    public void setActualDate(Integer actualDate) {
        this.actualDate = actualDate;
    }

    public Integer getActualDuration() {
        return actualDuration;
    }

    public Classroom actualDuration(Integer actualDuration) {
        this.actualDuration = actualDuration;
        return this;
    }

    public void setActualDuration(Integer actualDuration) {
        this.actualDuration = actualDuration;
    }

    public Integer getSudentPresent() {
        return sudentPresent;
    }

    public Classroom sudentPresent(Integer sudentPresent) {
        this.sudentPresent = sudentPresent;
        return this;
    }

    public void setSudentPresent(Integer sudentPresent) {
        this.sudentPresent = sudentPresent;
    }

    public Set<ClassLog> getClassLogIds() {
        return classLogIds;
    }

    public Classroom classLogIds(Set<ClassLog> classLogs) {
        this.classLogIds = classLogs;
        return this;
    }

    public Classroom addClassLogId(ClassLog classLog) {
        this.classLogIds.add(classLog);
        classLog.setClassroomId(this);
        return this;
    }

    public Classroom removeClassLogId(ClassLog classLog) {
        this.classLogIds.remove(classLog);
        classLog.setClassroomId(null);
        return this;
    }

    public void setClassLogIds(Set<ClassLog> classLogs) {
        this.classLogIds = classLogs;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public Classroom scheduleId(Schedule schedule) {
        this.scheduleId = schedule;
        return this;
    }

    public void setScheduleId(Schedule schedule) {
        this.scheduleId = schedule;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Classroom classroom = (Classroom) o;
        if (classroom.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), classroom.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Classroom{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            ", actualDate=" + getActualDate() +
            ", actualDuration=" + getActualDuration() +
            ", sudentPresent=" + getSudentPresent() +
            "}";
    }
}
