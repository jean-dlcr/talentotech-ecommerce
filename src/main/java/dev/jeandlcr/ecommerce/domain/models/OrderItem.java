package dev.jeandlcr.ecommerce.domain.models;

public class OrderItem {

    private int id;
    private int orderId;
    private Product product;
    private int quantity;
    private float price;
    private float subtotal;

    public OrderItem(int id, int orderId, Product product, int quantity, float price) {
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
}
