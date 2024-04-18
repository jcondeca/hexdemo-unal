package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.adapter;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.OrderItem;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.OrderRepository;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess.OrderDataAccessJPA;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess.OrderItemDataAccessJPA;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.OrderItemSQLEntity;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.OrderSQLEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Component("OrderSQLAdapter")
@AllArgsConstructor
public class OrderSQLAdapter implements OrderRepository {

    private OrderDataAccessJPA orderDataAccessJPA;

    private OrderItemDataAccessJPA orderItemDataAccessJPA;

    @Override
    public List<Order> getOrdersByUser(User user) {
        return List.of();
    }

    @Override
    public Optional<Order> getOrderById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = orderDataAccessJPA
                .findAll()
                .stream()
                .map(OrderSQLEntity::toOrder)
                .toList();

        orders.forEach(order -> {
            List<OrderItem> orderItems = orderItemDataAccessJPA
                    .findByOrderId(order.getId())
                    .stream()
                    .map(OrderItemSQLEntity::toOrderItem)
                    .toList();
            order.setItems(orderItems);
        });
        return orders;

    }

    @Override
    public void saveOrder(Order order) {
        orderDataAccessJPA.save(OrderSQLEntity.fromOrder(order));
        AtomicLong orderItemId = new AtomicLong(1L);
        order.getItems().stream().forEach(orderItem -> {
            OrderItemSQLEntity entity = OrderItemSQLEntity.fromOrderItem(order, orderItemId.getAndIncrement(), orderItem);
            orderItemDataAccessJPA.save(entity);
        });
    }
}
