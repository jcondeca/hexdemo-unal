package co.edu.unal.apps.hexdemo.infrastructure.inbound.web.controllers;

import co.edu.unal.apps.hexdemo.application.inbound.usecases.users.CreateUserUseCase;
import co.edu.unal.apps.hexdemo.application.inbound.usecases.users.GetAllUsersUseCase;
import co.edu.unal.apps.hexdemo.domain.model.User;
import co.edu.unal.apps.hexdemo.infrastructure.inbound.web.dto.CreateUserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetAllUsersUseCase getAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody CreateUserRequest request) {
        return createUserUseCase.createUser(request.getName(), request.getEmail(), request.getMaxOrderPrice());
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return getAllUsersUseCase.getAllUsers();
    }
}
