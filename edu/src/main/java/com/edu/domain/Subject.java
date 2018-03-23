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
 * A Subject.
 */
@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "mod_date")
    private Instant modDate;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "duration_year")
    private Integer durationYear;

    @Column(name = "duration_month")
    private Integer durationMonth;

    @Column(name = "duration_day")
    private Integer durationDay;

    @OneToMany(mappedBy = "subjectId")
    @JsonIgnore
    private Set<Batch> batchIds = new HashSet<>();

    @ManyToOne
    private Course courseId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Subject name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public Subject status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Subject createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Subject modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Long getFee() {
        return fee;
    }

    public Subject fee(Long fee) {
        this.fee = fee;
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Integer getDurationYear() {
        return durationYear;
    }

    public Subject durationYear(Integer durationYear) {
        this.durationYear = durationYear;
        return this;
    }

    public void setDurationYear(Integer durationYear) {
        this.durationYear = durationYear;
    }

    public Integer getDurationMonth() {
        return durationMonth;
    }

    public Subject durationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
        return this;
    }

    public void setDurationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
    }

    public Integer getDurationDay() {
        return durationDay;
    }

    public Subject durationDay(Integer durationDay) {
        this.durationDay = durationDay;
        return this;
    }

    public void setDurationDay(Integer durationDay) {
        this.durationDay = durationDay;
    }

    public Set<Batch> getBatchIds() {
        return batchIds;
    }

    public Subject batchIds(Set<Batch> batches) {
        this.batchIds = batches;
        return this;
    }

    public Subject addBatchId(Batch batch) {
        this.batchIds.add(batch);
        batch.setSubjectId(this);
        return this;
    }

    public Subject removeBatchId(Batch batch) {
        this.batchIds.remove(batch);
        batch.setSubjectId(null);
        return this;
    }

    public void setBatchIds(Set<Batch> batches) {
        this.batchIds = batches;
    }

    public Course getCourseId() {
        return courseId;
    }

    public Subject courseId(Course course) {
        this.courseId = course;
        return this;
    }

    public void setCourseId(Course course) {
        this.courseId = course;
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
        Subject subject = (Subject) o;
        if (subject.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), subject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Subject{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            ", fee=" + getFee() +
            ", durationYear=" + getDurationYear() +
            ", durationMonth=" + getDurationMonth() +
            ", durationDay=" + getDurationDay() +
            "}";
    }
}
