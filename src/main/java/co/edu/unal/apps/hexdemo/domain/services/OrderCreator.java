package co.edu.unal.apps.hexdemo.domain.services;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.OrderItem;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.OrderRepository;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class OrderCreator {

    private OrderRepository orderRepository;

    private OrderItemValidatorService orderItemValidatorService;

    public OrderCreator(OrderRepository orderRepository, OrderItemValidatorService orderItemValidatorService) {
        this.orderRepository = orderRepository;
        this.orderItemValidatorService = orderItemValidatorService;
    }

    public Order createOrder(User owner, List<OrderItem> items) {
        orderItemValidatorService.validateOrderItems(items);
        Order order = new Order();
        order.initializeOrder(owner);
        items.forEach(order::addOrderItem);
        order.validateData();
        order.printOrderItems();
        System.out.println("Total price: " + order.getTotalPrice());
        orderRepository.saveOrder(order);
        return order;
    }


}
