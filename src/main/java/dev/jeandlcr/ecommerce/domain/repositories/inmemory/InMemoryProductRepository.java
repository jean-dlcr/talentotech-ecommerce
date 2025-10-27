package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.interfaces.IProductRepository;
import dev.jeandlcr.ecommerce.domain.models.Product;

public class InMemoryProductRepository implements IProductRepository {

    private final List<Product> products = new ArrayList<>();
    private static int IDENTITY = 0;
    
    private final InMemoryBrandRepository brandRepository;
    private final InMemoryCategoryRepository categoryRepository;
    

    public InMemoryProductRepository(InMemoryBrandRepository brandRepository, InMemoryCategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    public void seed() {
        products.add(new Product(this.getNextId(), "Leche Laive Sin Lactosa para diluir", "Leche Laive Sin Lactosa para diluir botella 390g", 4.40f,
                brandRepository.getBrandByCode("LASILA"), categoryRepository.getCategoryByCode("LECHES"), true, null, null, null, null));
        products.add(new Product(this.getNextId(), "Leche Laive Sin Lactosa Light para diluir", "Leche Laive Sin Lactosa Light para diluir botella 390g", 4.40f,
                brandRepository.getBrandByCode("LASILA"), categoryRepository.getCategoryByCode("LECHES"), true, null, null, null, null));
        products.add(new Product(this.getNextId(), "Leche Laive clásica para diluir", "Leche Laive clásica para diluir botella 390g", 4.40f,
                brandRepository.getBrandByCode("LAIVE0"), categoryRepository.getCategoryByCode("LECHES"), true, null, null, null, null));

        products.add(new Product(this.getNextId(), "Laive Griego Frutos Rojos", "Laive Griego Frutos Rojos 800g", 4.40f,
                brandRepository.getBrandByCode("LAIGRG"), categoryRepository.getCategoryByCode("YOGFER"), true, null, null, null, null));
        products.add(new Product(this.getNextId(), "Laive Griego Fresa", "Laive Griego Fresa 800g", 4.40f,
                brandRepository.getBrandByCode("LAIGRG"), categoryRepository.getCategoryByCode("YOGFER"), true, null, null, null, null));
        products.add(new Product(this.getNextId(), "Laive Griego Natural", "Laive Griego Natural 800g", 4.40f,
                brandRepository.getBrandByCode("LAIGRG"), categoryRepository.getCategoryByCode("YOGFER"), true, null, null, null, null));    
    
    }

    @Override
    public void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        if (product.getId() == 0) {
            product.setId(getNextId());
        }
        products.add(product);
    }

    public void update(Product product){}
    public boolean delete(int productId){return false;}

    private int getMaxId() {
    int max_ = 0;
        for (Product p : products) {
            if (p.getId() > max_) {
                max_ = p.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !products.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // @Override 
    // public Product getProductByCode(String code) {
    //     for (Product p : products) {
    //         if (p.getCode().equalsIgnoreCase(code)) {
    //             return p;
    //         }
    //     }
    //     return null;
    // }
}
