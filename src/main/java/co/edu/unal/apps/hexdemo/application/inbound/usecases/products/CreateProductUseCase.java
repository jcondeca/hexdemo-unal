package co.edu.unal.apps.hexdemo.application.inbound.usecases.products;

import co.edu.unal.apps.hexdemo.application.inbound.proxy.ProductRepositoryProxy;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateProductUseCase {

    private final ProductRepositoryProxy productRepository;

    public CreateProductUseCase(ProductRepositoryProxy productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(String name, Double price) {
        Product product = new Product();
        product.initializeProduct(name, price);
        productRepository.getProductRepository().saveProduct(product);
        return product;
    }

}
