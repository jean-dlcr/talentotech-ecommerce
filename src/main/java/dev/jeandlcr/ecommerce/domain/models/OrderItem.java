package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;

public class OrderItem {

    private int id;
    private int orderId;
    private Product product;
    private int quantity;
    private float price;
    private float subtotal;
    private boolean active;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;

    public OrderItem(int id, int orderId, Product product, int quantity, float price, boolean active, LocalDateTime createdAt, int createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this.id = id;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = quantity * price;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Product getProduct() { return product; }
    public void setproduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
        this.subtotal = this.quantity * this.price;
    }

    public float getPrice() { return price; }
    public void setPrice(float price) { 
        this.price = price; 
        this.subtotal = this.quantity * this.price;
    }

    public float getSubtotal() { return subtotal; }

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
