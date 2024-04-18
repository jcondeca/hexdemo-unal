package co.edu.unal.apps.hexdemo.application.inbound.proxy;

import co.edu.unal.apps.hexdemo.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryProxy {
    private final UserRepository userRepository;

    public UserRepositoryProxy(@Qualifier("UserMongoAdapter") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
