package co.edu.unal.apps.hexdemo.domain.repositories;

import co.edu.unal.apps.hexdemo.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void saveUser(User user);
    Optional<User> getUserById(UUID id);
    List<User> getAllUsers();
}
