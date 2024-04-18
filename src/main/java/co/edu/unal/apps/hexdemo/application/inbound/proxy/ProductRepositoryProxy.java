package co.edu.unal.apps.hexdemo.application.inbound.proxy;

import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryProxy {

    private final ProductRepository productRepository;

    public ProductRepositoryProxy(@Qualifier("ProductMongoAdapter") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
