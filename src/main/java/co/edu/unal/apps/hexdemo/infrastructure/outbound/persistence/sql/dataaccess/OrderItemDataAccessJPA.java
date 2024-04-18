package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess;

import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.OrderItemSQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemDataAccessJPA extends JpaRepository<OrderItemSQLEntity, Long> {

    List<OrderItemSQLEntity> findByOrderId(UUID orderId);
}
