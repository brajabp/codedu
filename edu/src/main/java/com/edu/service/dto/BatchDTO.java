package com.edu.service.dto;


import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.edu.domain.enumeration.Status;

/**
 * A DTO for the Batch entity.
 */
public class BatchDTO implements Serializable {

    private Long id;

    private Status status;

    private Instant createDate;

    private Instant modDate;

    private Integer startDate;

    private Integer endDate;

    private Integer sudentCapacity;

    private Long subjectIdId;

    private Long studentIdId;

    private Long employeeIdId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Integer getSudentCapacity() {
        return sudentCapacity;
    }

    public void setSudentCapacity(Integer sudentCapacity) {
        this.sudentCapacity = sudentCapacity;
    }

    public Long getSubjectIdId() {
        return subjectIdId;
    }

    public void setSubjectIdId(Long subjectId) {
        this.subjectIdId = subjectId;
    }

    public Long getStudentIdId() {
        return studentIdId;
    }

    public void setStudentIdId(Long studentId) {
        this.studentIdId = studentId;
    }

    public Long getEmployeeIdId() {
        return employeeIdId;
    }

    public void setEmployeeIdId(Long employeeId) {
        this.employeeIdId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BatchDTO batchDTO = (BatchDTO) o;
        if(batchDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batchDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BatchDTO{" +
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
