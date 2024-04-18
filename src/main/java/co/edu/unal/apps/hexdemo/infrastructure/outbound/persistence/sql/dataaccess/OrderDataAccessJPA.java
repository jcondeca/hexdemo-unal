package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess;

import co.edu.unal.apps.hexdemo.domain.model.Order;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.OrderSQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderDataAccessJPA extends JpaRepository<OrderSQLEntity, UUID> {

}
