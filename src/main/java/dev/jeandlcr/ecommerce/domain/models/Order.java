package dev.jeandlcr.ecommerce.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private Customer customer;
    private User seller;
    private float total;
    private String status;
    private LocalDateTime createdAt;
    private int createdBy;
    private boolean active;
    private LocalDateTime updatedAt;
    private Integer updatedBy;
    private String observations;
    private String shippingAddress;

    private List<OrderItem> items = new ArrayList<>();

    public Order(int id, Customer customer, User seller, float total, String status,
                 String observations, String shippingAddress, boolean active, LocalDateTime createdAt, int createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        this.id = id;
        this.customer = customer;
        this.seller = seller;
        this.total = total;
        this.status = status;
        this.observations = observations;
        this.shippingAddress = shippingAddress;
        this.active= active;
        if(createdAt == null) createdAt = LocalDateTime.now();
        this.createdAt = createdAt;
        this.createdBy= createdBy;
        this.updatedAt= updatedAt;
        this.updatedBy= updatedBy;
        this.items = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Customer getcustomer() { return customer; }
    public void setcustomer(Customer customer) { this.customer = customer; }

    public User getSeller() { return seller; }
    public void setSeller(User seller) { this.seller = seller; }

    public float getTotal() { return total; }
    public void setTotal(float total) { this.total = total; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public int getCreatedBy() { return createdBy; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Integer getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(int updatedBy) { this.updatedBy = updatedBy; }

    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public void addItem(OrderItem item) {
        this.items.add(item);
        this.total += item.getSubtotal();
    }
}
