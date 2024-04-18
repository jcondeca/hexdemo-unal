package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess;

import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.UserSQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDataAccessJPA extends JpaRepository<UserSQLEntity, UUID> {
}
