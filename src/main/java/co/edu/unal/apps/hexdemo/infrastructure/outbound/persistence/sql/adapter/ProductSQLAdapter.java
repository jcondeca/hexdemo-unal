package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.adapter;

import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess.ProductDataAccessJPA;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.ProductSQLEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("ProductSQLAdapter")
public class ProductSQLAdapter implements ProductRepository {

    private final ProductDataAccessJPA productDataAccessJPA;

    public ProductSQLAdapter(ProductDataAccessJPA productDataAccessJPA) {
        this.productDataAccessJPA = productDataAccessJPA;
    }

    @Override
    public void saveProduct(Product product) {
        this.productDataAccessJPA.save(ProductSQLEntity.fromProduct(product));
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return this.productDataAccessJPA.findById(id).map(ProductSQLEntity::toProduct);
    }

    @Override
    public List<Product> getProducts() {
        return this.productDataAccessJPA.findAll()
                .stream()
                .map(ProductSQLEntity::toProduct)
                .toList();
    }
}
