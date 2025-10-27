package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Product;

public interface IProductRepository {
    void add(Product product);
    List<Product> getAll();
    Product getProductById(int id);
    //Product getProductByCode(String code);
}
