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
 * A Batch.
 */
@Entity
@Table(name = "batch")
public class Batch implements Serializable {

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

    @Column(name = "start_date")
    private Integer startDate;

    @Column(name = "end_date")
    private Integer endDate;

    @Column(name = "sudent_capacity")
    private Integer sudentCapacity;

    @OneToMany(mappedBy = "batchId")
    @JsonIgnore
    private Set<Schedule> scheduleIds = new HashSet<>();

    @OneToMany(mappedBy = "batchId")
    @JsonIgnore
    private Set<Enroll> enrollIds = new HashSet<>();

    @ManyToOne
    private Subject subjectId;

    @ManyToOne
    private Student studentId;

    @ManyToOne
    private Employee employeeId;

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

    public Batch status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Batch createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Batch modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public Batch startDate(Integer startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public Batch endDate(Integer endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Integer getSudentCapacity() {
        return sudentCapacity;
    }

    public Batch sudentCapacity(Integer sudentCapacity) {
        this.sudentCapacity = sudentCapacity;
        return this;
    }

    public void setSudentCapacity(Integer sudentCapacity) {
        this.sudentCapacity = sudentCapacity;
    }

    public Set<Schedule> getScheduleIds() {
        return scheduleIds;
    }

    public Batch scheduleIds(Set<Schedule> schedules) {
        this.scheduleIds = schedules;
        return this;
    }

    public Batch addScheduleId(Schedule schedule) {
        this.scheduleIds.add(schedule);
        schedule.setBatchId(this);
        return this;
    }

    public Batch removeScheduleId(Schedule schedule) {
        this.scheduleIds.remove(schedule);
        schedule.setBatchId(null);
        return this;
    }

    public void setScheduleIds(Set<Schedule> schedules) {
        this.scheduleIds = schedules;
    }

    public Set<Enroll> getEnrollIds() {
        return enrollIds;
    }

    public Batch enrollIds(Set<Enroll> enrolls) {
        this.enrollIds = enrolls;
        return this;
    }

    public Batch addEnrollId(Enroll enroll) {
        this.enrollIds.add(enroll);
        enroll.setBatchId(this);
        return this;
    }

    public Batch removeEnrollId(Enroll enroll) {
        this.enrollIds.remove(enroll);
        enroll.setBatchId(null);
        return this;
    }

    public void setEnrollIds(Set<Enroll> enrolls) {
        this.enrollIds = enrolls;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public Batch subjectId(Subject subject) {
        this.subjectId = subject;
        return this;
    }

    public void setSubjectId(Subject subject) {
        this.subjectId = subject;
    }

    public Student getStudentId() {
        return studentId;
    }

    public Batch studentId(Student student) {
        this.studentId = student;
        return this;
    }

    public void setStudentId(Student student) {
        this.studentId = student;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public Batch employeeId(Employee employee) {
        this.employeeId = employee;
        return this;
    }

    public void setEmployeeId(Employee employee) {
        this.employeeId = employee;
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
        Batch batch = (Batch) o;
        if (batch.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batch.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Batch{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            ", startDate=" + getStartDate() +
            ", endDate=" + getEndDate() +
            ", sudentCapacity=" + getSudentCapacity() +
            "}";
    }
}
