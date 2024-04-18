package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.adapter;

import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.UserRepository;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.nosql.dataaccess.UsersNoSQLDataAccess;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("UserMongoAdapter")
@AllArgsConstructor
public class UserMongoAdapter implements UserRepository {

    private final UsersNoSQLDataAccess userMongoDataAccess;

    public void saveUser(User user) {
        userMongoDataAccess.save(user);
    }

    public Optional<User> getUserById(UUID id) {
        return userMongoDataAccess.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMongoDataAccess.findAll();
    }
}
