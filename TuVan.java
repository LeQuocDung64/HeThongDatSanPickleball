package com.example.HeThongDatSanPickleball.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tuvan")
public class TuVan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String contactName;

    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private SupportType supportType;

    private String description;

    @Column(name = "is_resolved", nullable = false)
    private Boolean isResolved = false;

    public enum SupportType {
        TECHNICAL, BOOKING, PAYMENT, OTHER
    }

    // Constructor không tham số (bắt buộc cho JPA)
    public TuVan() {
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SupportType getSupportType() {
        return supportType;
    }

    public void setSupportType(SupportType supportType) {
        this.supportType = supportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(Boolean isResolved) {
        this.isResolved = isResolved;
    }
}