package com.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Enquiry.
 */
@Entity
@Table(name = "enquiry")
public class Enquiry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "enquiry_date")
    private Instant enquiryDate;

    @Column(name = "jhi_comment")
    private String comment;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "enquiryId")
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

    public Instant getEnquiryDate() {
        return enquiryDate;
    }

    public Enquiry enquiryDate(Instant enquiryDate) {
        this.enquiryDate = enquiryDate;
        return this;
    }

    public void setEnquiryDate(Instant enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public String getComment() {
        return comment;
    }

    public Enquiry comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhone() {
        return phone;
    }

    public Enquiry phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public Enquiry email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public Enquiry address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<FollowUp> getFollowUpIds() {
        return followUpIds;
    }

    public Enquiry followUpIds(Set<FollowUp> followUps) {
        this.followUpIds = followUps;
        return this;
    }

    public Enquiry addFollowUpId(FollowUp followUp) {
        this.followUpIds.add(followUp);
        followUp.setEnquiryId(this);
        return this;
    }

    public Enquiry removeFollowUpId(FollowUp followUp) {
        this.followUpIds.remove(followUp);
        followUp.setEnquiryId(null);
        return this;
    }

    public void setFollowUpIds(Set<FollowUp> followUps) {
        this.followUpIds = followUps;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public Enquiry organizationId(Organization organization) {
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
        Enquiry enquiry = (Enquiry) o;
        if (enquiry.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enquiry.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Enquiry{" +
            "id=" + getId() +
            ", enquiryDate='" + getEnquiryDate() + "'" +
            ", comment='" + getComment() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
}
