package co.edu.unal.apps.hexdemo.application.inbound.usecases.products;

import co.edu.unal.apps.hexdemo.application.inbound.proxy.ProductRepositoryProxy;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GetProductsUseCase {

    private final ProductRepositoryProxy productRepository;


    public GetProductsUseCase(ProductRepositoryProxy productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public List<Product> getProducts() {
        return productRepository.getProductRepository().getProducts();
    }
}
