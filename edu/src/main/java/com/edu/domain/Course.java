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
 * A Course.
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

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

    @OneToMany(mappedBy = "courseId")
    @JsonIgnore
    private Set<Enroll> enrollIds = new HashSet<>();

    @OneToMany(mappedBy = "courseId")
    @JsonIgnore
    private Set<Subject> subjectIds = new HashSet<>();

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

    public Course name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public Course status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Course createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Course modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Long getFee() {
        return fee;
    }

    public Course fee(Long fee) {
        this.fee = fee;
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Integer getDurationYear() {
        return durationYear;
    }

    public Course durationYear(Integer durationYear) {
        this.durationYear = durationYear;
        return this;
    }

    public void setDurationYear(Integer durationYear) {
        this.durationYear = durationYear;
    }

    public Integer getDurationMonth() {
        return durationMonth;
    }

    public Course durationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
        return this;
    }

    public void setDurationMonth(Integer durationMonth) {
        this.durationMonth = durationMonth;
    }

    public Integer getDurationDay() {
        return durationDay;
    }

    public Course durationDay(Integer durationDay) {
        this.durationDay = durationDay;
        return this;
    }

    public void setDurationDay(Integer durationDay) {
        this.durationDay = durationDay;
    }

    public Set<Enroll> getEnrollIds() {
        return enrollIds;
    }

    public Course enrollIds(Set<Enroll> enrolls) {
        this.enrollIds = enrolls;
        return this;
    }

    public Course addEnrollId(Enroll enroll) {
        this.enrollIds.add(enroll);
        enroll.setCourseId(this);
        return this;
    }

    public Course removeEnrollId(Enroll enroll) {
        this.enrollIds.remove(enroll);
        enroll.setCourseId(null);
        return this;
    }

    public void setEnrollIds(Set<Enroll> enrolls) {
        this.enrollIds = enrolls;
    }

    public Set<Subject> getSubjectIds() {
        return subjectIds;
    }

    public Course subjectIds(Set<Subject> subjects) {
        this.subjectIds = subjects;
        return this;
    }

    public Course addSubjectId(Subject subject) {
        this.subjectIds.add(subject);
        subject.setCourseId(this);
        return this;
    }

    public Course removeSubjectId(Subject subject) {
        this.subjectIds.remove(subject);
        subject.setCourseId(null);
        return this;
    }

    public void setSubjectIds(Set<Subject> subjects) {
        this.subjectIds = subjects;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public Course organizationId(Organization organization) {
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
        Course course = (Course) o;
        if (course.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Course{" +
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
