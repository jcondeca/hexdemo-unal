package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity;

import co.edu.unal.apps.hexdemo.domain.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductSQLEntity {
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private Double price;

    public static ProductSQLEntity fromProduct(Product product) {
        ProductSQLEntity productSQLEntity = new ProductSQLEntity();
        productSQLEntity.setId(product.getId());
        productSQLEntity.setName(product.getName());
        productSQLEntity.setPrice(product.getPrice());
        return productSQLEntity;
    }

    public Product toProduct() {
        Product product = new Product(this.id);
        product.initializeProduct(this.name, this.price);
        return product;
    }
}
