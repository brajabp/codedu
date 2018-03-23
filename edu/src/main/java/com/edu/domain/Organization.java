package com.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.edu.domain.enumeration.Status;

import com.edu.domain.enumeration.AccountStatus;

/**
 * A Organization.
 */
@Entity
@Table(name = "organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "mod_date")
    private Instant modDate;

    @OneToMany(mappedBy = "organizationId")
    @JsonIgnore
    private Set<Division> divisionIds = new HashSet<>();

    @OneToMany(mappedBy = "organizationId")
    @JsonIgnore
    private Set<Payment> paymentIds = new HashSet<>();

    @OneToMany(mappedBy = "organizationId")
    @JsonIgnore
    private Set<Enquiry> enquiryIds = new HashSet<>();

    @OneToMany(mappedBy = "organizationId")
    @JsonIgnore
    private Set<Course> courseIds = new HashSet<>();

    @OneToMany(mappedBy = "organizationId")
    @JsonIgnore
    private Set<Student> studentIds = new HashSet<>();

    @OneToMany(mappedBy = "organizationId")
    @JsonIgnore
    private Set<Employee> employeeIds = new HashSet<>();

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

    public Organization name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public Organization status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public Organization accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Organization createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Organization modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Set<Division> getDivisionIds() {
        return divisionIds;
    }

    public Organization divisionIds(Set<Division> divisions) {
        this.divisionIds = divisions;
        return this;
    }

    public Organization addDivisionId(Division division) {
        this.divisionIds.add(division);
        division.setOrganizationId(this);
        return this;
    }

    public Organization removeDivisionId(Division division) {
        this.divisionIds.remove(division);
        division.setOrganizationId(null);
        return this;
    }

    public void setDivisionIds(Set<Division> divisions) {
        this.divisionIds = divisions;
    }

    public Set<Payment> getPaymentIds() {
        return paymentIds;
    }

    public Organization paymentIds(Set<Payment> payments) {
        this.paymentIds = payments;
        return this;
    }

    public Organization addPaymentId(Payment payment) {
        this.paymentIds.add(payment);
        payment.setOrganizationId(this);
        return this;
    }

    public Organization removePaymentId(Payment payment) {
        this.paymentIds.remove(payment);
        payment.setOrganizationId(null);
        return this;
    }

    public void setPaymentIds(Set<Payment> payments) {
        this.paymentIds = payments;
    }

    public Set<Enquiry> getEnquiryIds() {
        return enquiryIds;
    }

    public Organization enquiryIds(Set<Enquiry> enquiries) {
        this.enquiryIds = enquiries;
        return this;
    }

    public Organization addEnquiryId(Enquiry enquiry) {
        this.enquiryIds.add(enquiry);
        enquiry.setOrganizationId(this);
        return this;
    }

    public Organization removeEnquiryId(Enquiry enquiry) {
        this.enquiryIds.remove(enquiry);
        enquiry.setOrganizationId(null);
        return this;
    }

    public void setEnquiryIds(Set<Enquiry> enquiries) {
        this.enquiryIds = enquiries;
    }

    public Set<Course> getCourseIds() {
        return courseIds;
    }

    public Organization courseIds(Set<Course> courses) {
        this.courseIds = courses;
        return this;
    }

    public Organization addCourseId(Course course) {
        this.courseIds.add(course);
        course.setOrganizationId(this);
        return this;
    }

    public Organization removeCourseId(Course course) {
        this.courseIds.remove(course);
        course.setOrganizationId(null);
        return this;
    }

    public void setCourseIds(Set<Course> courses) {
        this.courseIds = courses;
    }

    public Set<Student> getStudentIds() {
        return studentIds;
    }

    public Organization studentIds(Set<Student> students) {
        this.studentIds = students;
        return this;
    }

    public Organization addStudentId(Student student) {
        this.studentIds.add(student);
        student.setOrganizationId(this);
        return this;
    }

    public Organization removeStudentId(Student student) {
        this.studentIds.remove(student);
        student.setOrganizationId(null);
        return this;
    }

    public void setStudentIds(Set<Student> students) {
        this.studentIds = students;
    }

    public Set<Employee> getEmployeeIds() {
        return employeeIds;
    }

    public Organization employeeIds(Set<Employee> employees) {
        this.employeeIds = employees;
        return this;
    }

    public Organization addEmployeeId(Employee employee) {
        this.employeeIds.add(employee);
        employee.setOrganizationId(this);
        return this;
    }

    public Organization removeEmployeeId(Employee employee) {
        this.employeeIds.remove(employee);
        employee.setOrganizationId(null);
        return this;
    }

    public void setEmployeeIds(Set<Employee> employees) {
        this.employeeIds = employees;
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
        Organization organization = (Organization) o;
        if (organization.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), organization.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Organization{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", accountStatus='" + getAccountStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            "}";
    }
}
