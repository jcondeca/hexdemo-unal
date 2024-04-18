package co.edu.unal.apps.hexdemo.infrastructure.inbound.web.controllers;

import co.edu.unal.apps.hexdemo.application.inbound.usecases.products.CreateProductUseCase;
import co.edu.unal.apps.hexdemo.application.inbound.usecases.products.GetProductsUseCase;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.infrastructure.inbound.web.dto.CreateProductRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

        private final CreateProductUseCase createProductUseCase;
        private final GetProductsUseCase getProductsUseCase;

        public ProductController(CreateProductUseCase createProductUseCase, GetProductsUseCase getProductsUseCase) {
            this.createProductUseCase = createProductUseCase;
            this.getProductsUseCase = getProductsUseCase;
        }

        @PostMapping("/products")
        public Product createProduct(@RequestBody CreateProductRequest request) {
            return createProductUseCase.createProduct(request.getName(), request.getPrice());
        }

        @GetMapping("/products")
        public List<Product> getAllProducts() {
            return getProductsUseCase.getProducts();
        }
}
