package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.dataaccess;

import co.edu.unal.apps.hexdemo.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UsersNoSQLDataAccess extends MongoRepository<User, UUID> {
}
