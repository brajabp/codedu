package com.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.edu.domain.enumeration.Status;

import com.edu.domain.enumeration.JobType;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    private JobType jobType;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "mod_date")
    private Instant modDate;

    @Column(name = "join_date")
    private Instant joinDate;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "employeeId")
    @JsonIgnore
    private Set<Batch> batchIds = new HashSet<>();

    @OneToMany(mappedBy = "employeeId")
    @JsonIgnore
    private Set<FollowUp> followUpIds = new HashSet<>();

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

    public Employee name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public Employee status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public JobType getJobType() {
        return jobType;
    }

    public Employee jobType(JobType jobType) {
        this.jobType = jobType;
        return this;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Employee createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public Employee modDate(Instant modDate) {
        this.modDate = modDate;
        return this;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Instant getJoinDate() {
        return joinDate;
    }

    public Employee joinDate(Instant joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public void setJoinDate(Instant joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public Employee salary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public Employee phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public Employee email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public Employee address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Batch> getBatchIds() {
        return batchIds;
    }

    public Employee batchIds(Set<Batch> batches) {
        this.batchIds = batches;
        return this;
    }

    public Employee addBatchId(Batch batch) {
        this.batchIds.add(batch);
        batch.setEmployeeId(this);
        return this;
    }

    public Employee removeBatchId(Batch batch) {
        this.batchIds.remove(batch);
        batch.setEmployeeId(null);
        return this;
    }

    public void setBatchIds(Set<Batch> batches) {
        this.batchIds = batches;
    }

    public Set<FollowUp> getFollowUpIds() {
        return followUpIds;
    }

    public Employee followUpIds(Set<FollowUp> followUps) {
        this.followUpIds = followUps;
        return this;
    }

    public Employee addFollowUpId(FollowUp followUp) {
        this.followUpIds.add(followUp);
        followUp.setEmployeeId(this);
        return this;
    }

    public Employee removeFollowUpId(FollowUp followUp) {
        this.followUpIds.remove(followUp);
        followUp.setEmployeeId(null);
        return this;
    }

    public void setFollowUpIds(Set<FollowUp> followUps) {
        this.followUpIds = followUps;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public Employee organizationId(Organization organization) {
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
        Employee employee = (Employee) o;
        if (employee.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", jobType='" + getJobType() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            ", joinDate='" + getJoinDate() + "'" +
            ", salary=" + getSalary() +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
}
