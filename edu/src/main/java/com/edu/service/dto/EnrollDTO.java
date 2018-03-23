package com.edu.service.dto;


import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.edu.domain.enumeration.AccountStatus;

/**
 * A DTO for the Enroll entity.
 */
public class EnrollDTO implements Serializable {

    private Long id;

    private AccountStatus accountStatus;

    private Instant createDate;

    private Instant modDate;

    private Long courseIdId;

    private Long studentIdId;

    private Long batchIdId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModDate() {
        return modDate;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public Long getCourseIdId() {
        return courseIdId;
    }

    public void setCourseIdId(Long courseId) {
        this.courseIdId = courseId;
    }

    public Long getStudentIdId() {
        return studentIdId;
    }

    public void setStudentIdId(Long studentId) {
        this.studentIdId = studentId;
    }

    public Long getBatchIdId() {
        return batchIdId;
    }

    public void setBatchIdId(Long batchId) {
        this.batchIdId = batchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EnrollDTO enrollDTO = (EnrollDTO) o;
        if(enrollDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enrollDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EnrollDTO{" +
            "id=" + getId() +
            ", accountStatus='" + getAccountStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", modDate='" + getModDate() + "'" +
            "}";
    }
}
