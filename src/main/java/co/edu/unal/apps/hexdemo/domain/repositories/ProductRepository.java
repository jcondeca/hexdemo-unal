package co.edu.unal.apps.hexdemo.domain.repositories;

import co.edu.unal.apps.hexdemo.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void saveProduct(Product product);
    Optional<Product> getProductById(UUID id);
    List<Product> getProducts();
}
