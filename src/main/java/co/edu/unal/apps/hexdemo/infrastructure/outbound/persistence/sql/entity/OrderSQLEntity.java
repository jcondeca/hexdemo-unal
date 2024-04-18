package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class OrderSQLEntity {
    @Id
    private UUID id;

    @Column
    private UUID userId;

    @Column
    private Double total;

    public static OrderSQLEntity fromOrder(Order order) {
        OrderSQLEntity orderSQLEntity = new OrderSQLEntity();
        orderSQLEntity.setId(order.getId());
        orderSQLEntity.setUserId(order.getOwner().getId());
        orderSQLEntity.setTotal(order.getTotalPrice());

        return orderSQLEntity;
    }

    public Order toOrder() {
        Order order = new Order(this.id);
        order.setOwner(new User(this.userId));
        order.setItems(new ArrayList<>());
        return order;
    }
}
