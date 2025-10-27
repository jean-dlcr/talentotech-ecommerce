package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public abstract class EntityPerson {
    private int id;
    private String firstName;
    private String lastName;
    private String surName;
    private String document;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;

     public EntityPerson(int id, String firstName, String lastName, String surName,
                  String document, String email, String phone, String address, boolean active,
                  LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.document = document;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.active = active;
        if(createdAt == null) createdAt = LocalDateTime.now();
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Integer getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Integer getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + surName;
    }
}
