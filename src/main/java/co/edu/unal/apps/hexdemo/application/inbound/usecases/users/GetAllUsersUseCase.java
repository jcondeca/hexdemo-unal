package co.edu.unal.apps.hexdemo.application.inbound.usecases.users;

import co.edu.unal.apps.hexdemo.application.inbound.proxy.UserRepositoryProxy;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUsersUseCase {

    private final UserRepositoryProxy userRepositoryProxy;

    public GetAllUsersUseCase(UserRepositoryProxy userRepositoryProxy) {
        this.userRepositoryProxy = userRepositoryProxy;
    }

    public List<User> getAllUsers() {
        return userRepositoryProxy.getUserRepository().getAllUsers();
    }
}
