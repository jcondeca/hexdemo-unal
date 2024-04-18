package co.edu.unal.apps.hexdemo.application.inbound.proxy;

import co.edu.unal.apps.hexdemo.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryProxy {

    private final OrderRepository orderRepository;

    public OrderRepositoryProxy(@Qualifier("OrderSQLAdapter") OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }
}
