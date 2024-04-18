package co.edu.unal.apps.hexdemo.domain.services;

import co.edu.unal.apps.hexdemo.domain.model.OrderItem;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public class OrderItemValidatorService {
    private ProductRepository productRepository;

    public OrderItemValidatorService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void validateOrderItems(List<OrderItem> items) {
        if (productRepository == null) {
            throw new IllegalArgumentException("Product repository is null");
        }
        for (OrderItem item : items) {
            Optional<Product> productFromRepository = productRepository.getProductById(item.getProductId());
            if (productFromRepository.isEmpty()) {
                throw new IllegalArgumentException("Product with id " + item.getProductId() + " does not exist");
            } else {
                item.setProduct(productFromRepository.get());
            }
        }
    }
}
