package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String surName;
    private String email;
    private String password;
    private Role role;
    private Integer userDataId;
    private boolean active;
    private LocalDateTime createdAt;
    private int createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;

    public User(int id, String firstName, String lastName, String surName, String email, String password, Role role, boolean active, 
                LocalDateTime createdAt, int createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active= active;
        if(createdAt == null) createdAt = LocalDateTime.now();
        this.createdAt= createdAt;
        this.createdBy= createdBy;
        this.updatedAt= updatedAt;
        this.updatedBy= updatedBy;
    }

    public User(int id, Employee refEmployee, String password, Role role, boolean active, 
                LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this.id = id;
        this.userDataId = refEmployee.getId();
        this.firstName = refEmployee.getFirstName();
        this.lastName = refEmployee.getLastName();
        this.surName = refEmployee.getSurName();
        this.email = refEmployee.getEmail();
        this.password = password;
        this.role = role;
        this.active= active;
        if(createdAt == null) createdAt = LocalDateTime.now();
        this.createdAt = createdAt;
        this.createdBy= createdBy;
        this.updatedAt= updatedAt;
        this.updatedBy= updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // public int getEmployeeId() {
    //     return employeeId;
    // }

    // public void setEmployeeId(int employeeId) {
    //     this.employeeId = employeeId;
    // }

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

    public void setsurName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUserDataId() { return userDataId; }
    public void setUserDataId(Integer userDataId) { this.userDataId = userDataId; }

    public boolean isActive() { return this.active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return this.createdAt; }
    //public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public int getCreatedBy() { return this.createdBy; }
    //public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getUpdatedAt() { return this.updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Integer getUpdatedBy() { return this.updatedBy; }
    public void setUpdatedBy(int updatedBy) { this.updatedBy = updatedBy; }


}
