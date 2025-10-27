package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public class Customer extends EntityPerson {

    private CustomerType customerType;
    private String personalEmail;

    public Customer(int id, String document, CustomerType customerType, String firstName, String lastName, String surName,
                    String email, String personalEmail, String phone, String address, boolean active,
                    LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        super(id, firstName, lastName, surName, document, email, phone, address, active, createdAt, createdBy, updatedAt, updatedBy);
        if(!isValidContactInfo()){
            throw new IllegalArgumentException("Cliente debe tener al menos dos de: email, teléfono, dirección.");
        }
        this.customerType = customerType;
    }

    private boolean isValidContactInfo() {
        int count = 0;

        if (getPhone() != null && !getPhone().isEmpty()) count++;
        if (getAddress() != null && !getAddress().isEmpty()) count++;
        if (hasValidEmail()) count++;

        return count >= 2;
    }

    private boolean hasValidEmail() {
        return (getEmail() != null && !getEmail().isEmpty())
            || (personalEmail != null && !personalEmail.isEmpty());
    }


    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getPersonalEmail() { return this.personalEmail; }
    public void setPersonalEmail(String email) { this.personalEmail = email; }    

}
