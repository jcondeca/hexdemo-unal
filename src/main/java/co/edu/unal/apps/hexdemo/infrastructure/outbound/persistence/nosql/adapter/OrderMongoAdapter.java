package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.adapter;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.OrderRepository;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.dataaccess.OrdersNoSQLDataAccess;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("OrderMongoAdapter")
@AllArgsConstructor
public class OrderMongoAdapter implements OrderRepository {

    private final OrdersNoSQLDataAccess ordersNoSQLDataAccess;

    @Override
    public void saveOrder(Order order) {
        ordersNoSQLDataAccess.save(order);
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        return List.of();
    }

    @Override
    public Optional<Order> getOrderById(UUID id) {
        return ordersNoSQLDataAccess.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return ordersNoSQLDataAccess.findAll();
    }
}
