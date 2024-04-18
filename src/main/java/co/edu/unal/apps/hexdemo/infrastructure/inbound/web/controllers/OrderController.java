package co.edu.unal.apps.hexdemo.infrastructure.inbound.web.controllers;

import co.edu.unal.apps.hexdemo.application.inbound.usecases.orders.CreateOrderUseCase;
import co.edu.unal.apps.hexdemo.application.inbound.usecases.orders.GetAllOrdersUseCase;
import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.infrastructure.inbound.web.dto.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private final CreateOrderUseCase createOrderUseCase;
    private final GetAllOrdersUseCase getAllOrdersUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, GetAllOrdersUseCase getAllUsersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getAllOrdersUseCase = getAllUsersUseCase;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return createOrderUseCase.createOrder(UUID.fromString(request.getUserId()), request.getItems());
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return getAllOrdersUseCase.getAllOrders();
    }
}
