package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Category;

public interface ICategoryRepository {
    void add(Category category);
    List<Category> getAll();
    Category getCategoryById(int id);
    Category getCategoryByCode(String code);
}