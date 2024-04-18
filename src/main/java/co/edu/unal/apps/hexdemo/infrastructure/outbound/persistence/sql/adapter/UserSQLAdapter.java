package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.adapter;

import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.UserRepository;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.dataaccess.UserDataAccessJPA;
import co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity.UserSQLEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("UserSQLAdapter")
public class UserSQLAdapter implements UserRepository {

    @Autowired
    private UserDataAccessJPA userDataAccessJPA;

    @Override
    public void saveUser(User user) {
        userDataAccessJPA.save(UserSQLEntity.fromUser(user));
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userDataAccessJPA.findById(id).map(UserSQLEntity::toUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userDataAccessJPA.findAll().stream().map(UserSQLEntity::toUser).toList();
    }
}
