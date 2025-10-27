package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public class Seller {

    private int id;
    private Employee employee;
    private String sellerCode;
    private String region;
    private float commissionRate;
    private boolean active;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;

    public Seller(int id, Employee refEmployee, String sellerCode, String region, float commissionRate,
            LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this(id, refEmployee, sellerCode, region, commissionRate, refEmployee.isActive(), createdAt, createdBy,
                updatedAt, updatedBy);
    }

    public Seller(int id, Employee refEmployee, String sellerCode, String region, float commissionRate, boolean active,
            LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        if (refEmployee == null) {
            throw new IllegalArgumentException("\nNo se puede crear el vendedor sin la referencia de empleado.");
        }
        this.id = id;
        this.employee = refEmployee;
        this.sellerCode = sellerCode;
        this.region = region;
        this.commissionRate = commissionRate;
        this.active = active;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployeeData() {
        return this.employee;
    }

    public String getSellerCode() {
        return this.sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getCommissionRate() {
        return this.commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}
