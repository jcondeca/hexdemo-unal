package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess;

import co.edu.unal.apps.hexdemo.domain.model.Product;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.ProductSQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductDataAccessJPA extends JpaRepository<ProductSQLEntity, UUID> {

    List<ProductSQLEntity> findAll();
}
