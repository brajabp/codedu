package com.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.edu.domain.enumeration.AccountStatus;

/**
 * A Enroll.
 */
@Entity
@Table(name = "enroll")
public class Enroll implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "mod_date")
    private Instant modDate;

    @OneToMany(mappedBy = "enrollId")
    @JsonIgnore
    private Set<Payment> paymentIds = new HashSet<>();

    @ManyToOne
    private Course courseId;

    @ManyToOne
    private Student studentId;

    @ManyToOne
    private Batch batchId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public Enroll accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Enroll createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Enroll modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Set<Payment> getPaymentIds() {
        return paymentIds;
    }

    public Enroll paymentIds(Set<Payment> payments) {
        this.paymentIds = payments;
        return this;
    }

    public Enroll addPaymentId(Payment payment) {
        this.paymentIds.add(payment);
        payment.setEnrollId(this);
        return this;
    }

    public Enroll removePaymentId(Payment payment) {
        this.paymentIds.remove(payment);
        payment.setEnrollId(null);
        return this;
    }

    public void setPaymentIds(Set<Payment> payments) {
        this.paymentIds = payments;
    }

    public Course getCourseId() {
        return courseId;
    }

    public Enroll courseId(Course course) {
        this.courseId = course;
        return this;
    }

    public void setCourseId(Course course) {
        this.courseId = course;
    }

    public Student getStudentId() {
        return studentId;
    }

    public Enroll studentId(Student student) {
        this.studentId = student;
        return this;
    }

    public void setStudentId(Student student) {
        this.studentId = student;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public Enroll batchId(Batch batch) {
        this.batchId = batch;
        return this;
    }

    public void setBatchId(Batch batch) {
        this.batchId = batch;
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
        Enroll enroll = (Enroll) o;
        if (enroll.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enroll.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Enroll{" +
            "id=" + getId() +
            ", accountStatus='" + getAccountStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            "}";
    }
}
