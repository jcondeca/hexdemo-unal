package co.edu.unal.apps.hexdemo.application.inbound.usecases.users;

import co.edu.unal.apps.hexdemo.application.inbound.proxy.UserRepositoryProxy;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {

    private final UserRepositoryProxy userRepositoryProxy;

    public CreateUserUseCase(
            UserRepositoryProxy userRepositoryProxy) {
        this.userRepositoryProxy = userRepositoryProxy;
    }

    @Transactional
    public User createUser(String name, String email, Double maxOrderPrice) {
        User toSave = new User();
        toSave.initializeUser(name, email, maxOrderPrice);
        userRepositoryProxy.getUserRepository().saveUser(toSave);
        return toSave;
    }
}
