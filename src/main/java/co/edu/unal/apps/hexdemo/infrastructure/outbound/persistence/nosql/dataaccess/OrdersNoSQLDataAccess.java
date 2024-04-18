package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.dataaccess;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrdersNoSQLDataAccess extends MongoRepository<Order, UUID> {
}
