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
 * A Student.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

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

    @Column(name = "duration_year")
    private Integer durationYear;

    @Column(name = "duration_month")
    private Integer durationMonth;

    @Column(name = "duration_day")
    private Integer durationDay;

    @OneToMany(mappedBy = "studentId")
    @JsonIgnore
    private Set<Enroll> enrollIds = new HashSet<>();

    @OneToMany(mappedBy = "studentId")
    @JsonIgnore
    private Set<Batch> batchIds = new HashSet<>();

    @ManyToOne
    private Organization organizationId;

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

    public Student name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public Student status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Student createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Student modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Integer getDurationYear() {
        return durationYear;
    }

    public Student durationYear(Integer durationYear) {
        this.durationYear = durationYear;
        return this;
    }

    public void setDurationYear(Integer durationYear) {
        this.durationYear = durationYear;
    }

    public Integer getDurationMonth() {
        return durationMonth;
    }

    public Student durationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
        return this;
    }

    public void setDurationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
    }

    public Integer getDurationDay() {
        return durationDay;
    }

    public Student durationDay(Integer durationDay) {
        this.durationDay = durationDay;
        return this;
    }

    public void setDurationDay(Integer durationDay) {
        this.durationDay = durationDay;
    }

    public Set<Enroll> getEnrollIds() {
        return enrollIds;
    }

    public Student enrollIds(Set<Enroll> enrolls) {
        this.enrollIds = enrolls;
        return this;
    }

    public Student addEnrollId(Enroll enroll) {
        this.enrollIds.add(enroll);
        enroll.setStudentId(this);
        return this;
    }

    public Student removeEnrollId(Enroll enroll) {
        this.enrollIds.remove(enroll);
        enroll.setStudentId(null);
        return this;
    }

    public void setEnrollIds(Set<Enroll> enrolls) {
        this.enrollIds = enrolls;
    }

    public Set<Batch> getBatchIds() {
        return batchIds;
    }

    public Student batchIds(Set<Batch> batches) {
        this.batchIds = batches;
        return this;
    }

    public Student addBatchId(Batch batch) {
        this.batchIds.add(batch);
        batch.setStudentId(this);
        return this;
    }

    public Student removeBatchId(Batch batch) {
        this.batchIds.remove(batch);
        batch.setStudentId(null);
        return this;
    }

    public void setBatchIds(Set<Batch> batches) {
        this.batchIds = batches;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public Student organizationId(Organization organization) {
        this.organizationId = organization;
        return this;
    }

    public void setOrganizationId(Organization organization) {
        this.organizationId = organization;
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
        Student student = (Student) o;
        if (student.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            ", durationYear=" + getDurationYear() +
            ", durationMonth=" + getDurationMonth() +
            ", durationDay=" + getDurationDay() +
            "}";
    }
}
