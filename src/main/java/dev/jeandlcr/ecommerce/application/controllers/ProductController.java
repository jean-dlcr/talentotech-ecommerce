package dev.jeandlcr.ecommerce.application.controllers;

import dev.jeandlcr.ecommerce.core.responses.Response;
import dev.jeandlcr.ecommerce.domain.models.Product;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryBrandRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryCategoryRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryProductRepository;

import java.util.List;

public class ProductController {

    
    private final InMemoryCategoryRepository categoryRepository = new InMemoryCategoryRepository();
    private final InMemoryBrandRepository brandRepository = new InMemoryBrandRepository();
    private final InMemoryProductRepository productRepository = new InMemoryProductRepository(brandRepository, categoryRepository );

    public Response<Product> addProduct(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            return Response.error("El nombre del producto es obligatorio");
        }

        // Validar categoría y marca
        if (product.getCategoryById() == null || categoryRepository.getCategoryById(product.getCategoryById().getId()) == null) {
            return Response.error("La categoría especificada no existe");
        }

        if (product.getBrandById() == null || brandRepository.getBrandById(product.getBrandById().getId()) == null) {
            return Response.error("La marca especificada no existe");
        }

        //Product saved = 
        productRepository.add(product);
        return Response.success("Producto agregado correctamente", product);
    }

    public Response<List<Product>> listProducts() {
        List<Product> all = productRepository.getAll();
        if (all.isEmpty()) {
            return Response.error("No hay productos registrados");
        }
        return Response.success("Lista de productos", all);
    }

    public Response<Product> getProduct(int id) {
        Product resProduct = productRepository.getProductById(id);
        if (resProduct != null) {
            return Response.success("Producto encontrado", resProduct);
        } else {
            return Response.error("No se encontró ningún producto con ese ID");
        }
    }

    public Response<Product> updateProduct(int id, Product updatedProduct) {
        Product existing = productRepository.getProductById(id);
        if (existing  == null) {
            return Response.error("No existe un producto con ese ID");
        }
        updatedProduct.setId(id);
        productRepository.update(updatedProduct);
        return Response.success("Producto actualizado correctamente", updatedProduct);
    }

    public Response<String> deleteProduct(int productId) {
        boolean removed = productRepository.delete(productId);
        if (!removed) {
            return Response.error("No se pudo eliminar, producto no encontrado");
        }
        return Response.success("Producto eliminado correctamente", null);
    }
}
