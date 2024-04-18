package co.edu.unal.apps.hexdemo.application.inbound.usecases.orders;

import co.edu.unal.apps.hexdemo.application.inbound.proxy.OrderRepositoryProxy;
import co.edu.unal.apps.hexdemo.application.inbound.proxy.ProductRepositoryProxy;
import co.edu.unal.apps.hexdemo.application.inbound.proxy.UserRepositoryProxy;
import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GetAllOrdersUseCase {

    private final OrderRepositoryProxy orderRepositoryProxy;
    private final ProductRepositoryProxy productRepositoryProxy;
    private final UserRepositoryProxy userRepositoryProxy;

    public GetAllOrdersUseCase(OrderRepositoryProxy orderRepositoryProxy, ProductRepositoryProxy productRepositoryProxy, UserRepositoryProxy userRepositoryProxy) {
        this.orderRepositoryProxy = orderRepositoryProxy;
        this.productRepositoryProxy = productRepositoryProxy;
        this.userRepositoryProxy = userRepositoryProxy;
    }

    public List<Order> getAllOrders() {
        List<Order> toReturn = this.orderRepositoryProxy.getOrderRepository().getAllOrders();
        toReturn.forEach(order -> {
            order.getItems().forEach(item -> {
                item.setProduct(this.productRepositoryProxy.getProductRepository().getProductById(item.getProduct().getId()).get());
            });
            System.out.println("Attempting to get User " + order.getOwner().getId() + " from repository");
            Optional<User> user = this.userRepositoryProxy.getUserRepository().getUserById(order.getOwner().getId());
            if (user.isPresent())
                order.setOwner(user.get());
            else
                System.out.println("User not found in repository " + order.getOwner().getId());
        });
        return toReturn;
    }
}
