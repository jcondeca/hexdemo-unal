package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.adapter;

import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.dataaccess.ProductsNoSQLDataAccess;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("ProductMongoAdapter")
@AllArgsConstructor
public class ProductMongoAdapter implements ProductRepository {

    private final ProductsNoSQLDataAccess productsNoSQLDataAccess;

    public void saveProduct(Product product) {
        productsNoSQLDataAccess.save(product);
    }

    public Optional<Product> getProductById(UUID id) {
        return productsNoSQLDataAccess.findById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productsNoSQLDataAccess.findAll();
    }
}
