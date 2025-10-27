package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public class Brand {
    private int id;
    private String code;
    private String name;
    private String description;
    private boolean active;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;

    public Brand() {}

    public Brand(int id, String code, String name, String description, boolean active,
                  LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.active = active;
        if(createdAt == null) createdAt = LocalDateTime.now();
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; } 
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public Integer getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(Integer updatedBy) { this.updatedBy = updatedBy; }
}
