package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Product;

public class ProductRepository {

    private static final List<Product> products = new ArrayList<>();
    private static Long sequence = 1L;

    // private static final CategoryRepository categoryRepo = new CategoryRepository();
    // private static final BrandRepository brandRepo = new BrandRepository();

    // static {
    //     products.add(new Product(sequence++, "Leche Laive Sin Lactosa para diluir", "Leche Laive Sin Lactosa para diluir botella 390g", 4.40f,
    //             categoryRepo.getCategoryById(1L), brandRepo.getBrandById(2L)));
    //     products.add(new Product(sequence++, "Leche Laive Sin Lactosa Light para diluir", "Leche Laive Sin Lactosa Light para diluir botella 390g", 4.40f,
    //             categoryRepo.getCategoryById(1L), brandRepo.getBrandById(2L)));
    //     products.add(new Product(sequence++, "Leche Laive clásica para diluir", "Leche Laive clásica para diluir botella 390g", 4.40f,
    //             categoryRepo.getCategoryById(1L), brandRepo.getBrandById(6L)));

    //     products.add(new Product(sequence++, "Laive Griego Frutos Rojos", "Laive Griego Frutos Rojos 800g", 4.40f,
    //             categoryRepo.getCategoryById(3L), brandRepo.getBrandById(9L)));
    //     products.add(new Product(sequence++, "Laive Griego Fresa", "Laive Griego Fresa 800g", 4.40f,
    //             categoryRepo.getCategoryById(3L), brandRepo.getBrandById(9L)));
    //     products.add(new Product(sequence++, "Laive Griego Natural", "Laive Griego Natural 800g", 4.40f,
    //             categoryRepo.getCategoryById(3L), brandRepo.getBrandById(9L)));    
    
    // }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(sequence++);
        } else {
            // Si existe un producto con el mismo ID, eliminarlo antes de reemplazar
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.remove(i);
                    break;
                }
            }
        }
        products.add(product);
        return product;
    }

    public boolean deleteProduct(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();
        sequence = 1L;
    }
}
