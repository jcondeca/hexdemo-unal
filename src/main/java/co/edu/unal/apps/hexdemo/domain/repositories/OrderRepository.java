package co.edu.unal.apps.hexdemo.domain.repositories;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    void saveOrder(Order order);
    List<Order> getOrdersByUser(User user);
    Optional<Order> getOrderById(UUID id);
    List<Order> getAllOrders();
}
