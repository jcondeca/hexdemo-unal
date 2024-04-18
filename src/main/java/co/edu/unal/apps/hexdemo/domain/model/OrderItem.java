package co.edu.unal.apps.hexdemo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Getter
@NoArgsConstructor
public class OrderItem {
    private Long id = 0L;
    private Product product;
    private int quantity;

    public OrderItem(Long id) {
        this.id = id;
    }

    public void initialize(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        validateData();
    }

    private void validateData() {
        if (product == null) {
            throw new IllegalArgumentException("Product is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }

    @JsonIgnore
    public UUID getProductId() {
        return product.getId();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return (product.getPrice() == null) ? 0 : product.getPrice() * quantity;
    }

    public String toString() {
        return String.format("Product: %s, Quantity: %d, Total: %.2f",
                product.getName() == null ? product.getId() : product.getName(),
                quantity, getTotal());
    }

}
