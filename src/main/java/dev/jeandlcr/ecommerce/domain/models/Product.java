package dev.jeandlcr.ecommerce.domain.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Product {
    private Long id;
    private String name;
    private String description;
    private float price;

    private Category category;
    private Brand brand;

    public Product() {}

    public Product(Long id, String name, String description, float price, Category category, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.brand = brand;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public Category getCategoryById() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Brand getBrandById() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + (category != null ? category.getName() : "none") +
                ", brand=" + (brand != null ? brand.getName() : "none") +
                '}';
    }
}
