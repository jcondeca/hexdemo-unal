package co.edu.unal.apps.hexdemo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private Double price;

    public Product(UUID id) {
        this.id = id;
    }

    public void initializeProduct(String name, Double price) {
        if (id == null)
            setId(UUID.randomUUID());
        setName(name);
        setPrice(price);
        validateData();
    }

    private void validateData() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
