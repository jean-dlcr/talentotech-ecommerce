package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.interfaces.ICategoryRepository;
import dev.jeandlcr.ecommerce.domain.models.Brand;
import dev.jeandlcr.ecommerce.domain.models.Category;

public class InMemoryCategoryRepository implements ICategoryRepository {

    private static final List<Category> categories = new ArrayList<>();
    private static int IDENTITY = 0;

    public void seed() {
        categories.add(new Category(this.getNextId(), "LECHES", "Leches", "Productos lácteos líquidos", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "BELACT", "Bebidas Lácteas", "Bebidas con base de leche", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "YOGFER", "Yogures y Fermentados", "Yogures, bebibles y fermentados", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "QUESOS", "Quesos", "Quesos de todo tipo", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "EMBUTI", "Embutidos", "Jamones, salchichas y otros embutidos", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "UNTABL", "Untables", "Mantequillas y cremas", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "VEGETA", "Vegetales", "Productos vegetales procesados", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "CULINA", "Culinarios", "Ingredientes para cocinar", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "BEFRUT", "Bebidas Frutadas", "Bebidas con frutas", true, null, null, null, null));
        categories.add(new Category(this.getNextId(), "POSLIS", "Postres Listos", "Postres listos para servir", true, null, null, null, null));
    }

    @Override
    public void add(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }
        if (category.getId() == 0) {
            category.setId(getNextId());
        }
        categories.add(category);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Category c : categories) {
            if (c.getId() > max_) {
                max_ = c.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !categories.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Category getCategoryByCode(String code) {
        for (Category c : categories) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    // public List<Category> getCategoriesByName(String name) {
    //     List<Category> results = new ArrayList<>();
    //     for (Category c : categories) {
    //         if (c.getName().toLowerCase().contains(name.toLowerCase())) {
    //             results.add(c);
    //         }
    //     }
    //     return results;
    // }

}
