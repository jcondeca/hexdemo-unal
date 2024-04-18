package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.OrderItem;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItemSQLEntity {
    @Id
    private Long id;

    @Column
    private UUID orderId;

    @Column
    private UUID productId;

    @Column
    private Integer quantity;

    @Column
    private Double subtotal;

    public static OrderItemSQLEntity fromOrderItem(Order parentOrder, Long id, OrderItem orderItem) {
        OrderItemSQLEntity orderItemSQLEntity = new OrderItemSQLEntity();
        orderItemSQLEntity.setId(id);
        orderItemSQLEntity.setOrderId(parentOrder.getId());
        orderItemSQLEntity.setProductId(orderItem.getProductId());
        orderItemSQLEntity.setQuantity(orderItem.getQuantity());
        orderItemSQLEntity.setSubtotal(orderItem.getTotal());
        return orderItemSQLEntity;
    }

    public OrderItem toOrderItem() {
        OrderItem orderItem = new OrderItem(this.id);
        Product product = new Product(productId);
        orderItem.setQuantity(this.quantity);
        orderItem.setProduct(product);
        return orderItem;
    }
}
