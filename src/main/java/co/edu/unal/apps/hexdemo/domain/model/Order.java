package co.edu.unal.apps.hexdemo.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Order {
    private UUID id;
    private User owner;
    private List<OrderItem> items;

    public Order(UUID id) {
        this.id = id;
    }

    public void initializeOrder(User owner) {
        if (id == null)
            setId(UUID.randomUUID());
        setOwner(owner);
        items = new ArrayList<>();
    }

    public void validateData() {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order Items cannot be empty");
        }
        if (owner.getMaxPriceOrder() < getTotalPrice()) {
            throw new IllegalArgumentException("Total price of the order is greater than the maximum price allowed");
        }
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getTotal).sum();
    }

    public void printOrderItems() {
        items.forEach(System.out::println);
    }

    public void addOrderItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Order Item cannot be null");
        }
        items.add(item);
        validateData();
    }
}
