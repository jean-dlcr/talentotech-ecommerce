package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public class Employee extends EntityPerson {
    
    private String personalEmail;
    private LocalDateTime hiredAt;
    
    public Employee(int id, String document, String firstName, String lastName, String surName,
                    String email, String personalEmail, String phone, String address, LocalDateTime hiredAt, boolean active,
                    LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {

        super(id, firstName, lastName, surName, document, email, phone, address, active, createdAt, createdBy, updatedAt, updatedBy);
        this.personalEmail = personalEmail;
        if(hiredAt == null) hiredAt = super.getCreatedAt();
        this.hiredAt = hiredAt;
    }

    public String getPersonalEmail() { return this.personalEmail; };
    public void setPersonalEmail(String personalEmail) { this.personalEmail = personalEmail; }

    public LocalDateTime getHiredAt() { return this.hiredAt; }
    public void setHiredAt(LocalDateTime hiredAt) { this.hiredAt = hiredAt; }
}
