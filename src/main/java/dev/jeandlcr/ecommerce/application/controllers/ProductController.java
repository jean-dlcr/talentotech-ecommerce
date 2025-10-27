package dev.jeandlcr.ecommerce.application.controllers;

import dev.jeandlcr.ecommerce.core.responses.Response;
import dev.jeandlcr.ecommerce.domain.models.Product;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryBrandRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryCategoryRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.ProductRepository;

import java.util.List;

public class ProductController {

    private final ProductRepository productRepository = new ProductRepository();
    private final InMemoryCategoryRepository categoryRepository = new InMemoryCategoryRepository();
    private final InMemoryBrandRepository brandRepository = new InMemoryBrandRepository();

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

        Product saved = productRepository.save(product);
        return Response.success("Producto agregado correctamente", saved);
    }

    public Response<List<Product>> listProducts() {
        List<Product> all = productRepository.getAllProducts();
        if (all.isEmpty()) {
            return Response.error("No hay productos registrados");
        }
        return Response.success("Lista de productos", all);
    }

    public Response<Product> getProduct(Long id) {
        Product resProduct = productRepository.getProduct(id);
        if (resProduct != null) {
            return Response.success("Producto encontrado", resProduct);
        } else {
            return Response.error("No se encontró ningún producto con ese ID");
        }
    }

    public Response<Product> updateProduct(Long id, Product updatedProduct) {
        Product existing = productRepository.getProduct(id);
        if (existing  == null) {
            return Response.error("No existe un producto con ese ID");
        }
        updatedProduct.setId(id);
        productRepository.save(updatedProduct);
        return Response.success("Producto actualizado correctamente", updatedProduct);
    }

    public Response<String> deleteProduct(Long id) {
        boolean removed = productRepository.deleteProduct(id);
        if (!removed) {
            return Response.error("No se pudo eliminar, producto no encontrado");
        }
        return Response.success("Producto eliminado correctamente", null);
    }
}
