package co.edu.unal.apps.hexdemo.application.inbound.usecases.orders;

import co.edu.unal.apps.hexdemo.application.inbound.proxy.OrderRepositoryProxy;
import co.edu.unal.apps.hexdemo.application.inbound.proxy.ProductRepositoryProxy;
import co.edu.unal.apps.hexdemo.application.inbound.proxy.UserRepositoryProxy;
import co.edu.unal.apps.hexdemo.application.inbound.usecases.dto.OrderItemDTO;
import co.edu.unal.apps.hexdemo.application.outbound.services.NotificationService;
import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.OrderItem;
import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.ProductRepository;
import co.edu.unal.apps.hexdemo.domain.repositories.UserRepository;
import co.edu.unal.apps.hexdemo.domain.services.OrderCreator;
import co.edu.unal.apps.hexdemo.domain.services.OrderItemValidatorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class CreateOrderUseCase {

    private final OrderRepositoryProxy orderRepositoryProxy;
    private final UserRepositoryProxy userRepository;
    private final NotificationService notificationService;

    private OrderCreator orderCreator;

    public CreateOrderUseCase(OrderRepositoryProxy orderRepositoryProxy,
                              ProductRepositoryProxy productRepository,
                              UserRepositoryProxy userRepository,
                              NotificationService notificationService) {
        this.orderRepositoryProxy = orderRepositoryProxy;
        this.userRepository = userRepository;
        this.notificationService = notificationService;

        this.orderCreator = new OrderCreator(
                this.orderRepositoryProxy.getOrderRepository(),
                new OrderItemValidatorService(productRepository.getProductRepository())
                );
    }

    @Transactional
    public Order createOrder(UUID userId, List<OrderItemDTO> items) {
        Optional<User> user = userRepository.getUserRepository().getUserById(userId);
        Order order;
        if (user.isPresent()) {
            order = orderCreator.createOrder(user.get(), items.stream().map(item -> {
                OrderItem orderItem = new OrderItem();
                Product product = new Product(UUID.fromString(item.getProductId()));
                orderItem.initialize(product, item.getQuantity());
                return orderItem;
            }).collect(Collectors.toList()));
            notificationService.sendNotification("Order created successfully");
            return order;
        } else {
            throw new RuntimeException("Order not created, user not found");
        }
    }

}