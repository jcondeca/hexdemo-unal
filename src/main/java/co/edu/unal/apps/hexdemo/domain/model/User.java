package co.edu.unal.apps.hexdemo.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
public class User {
    private UUID id;
    private String name;
    private String email;
    private Double maxPriceOrder;

    public User(UUID id) {
        this.id = id;
    }

    public void initializeUser(String name, String email, Double maxPriceOrder) {
        if (id == null)
            setId(UUID.randomUUID());
        setName(name);
        setEmail(email);
        setMaxPriceOrder(maxPriceOrder);
        validateData();
    }

    private void validateData() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (maxPriceOrder == null || maxPriceOrder <= 0) {
            throw new IllegalArgumentException("Max price order must be greater than 0");
        }
    }
}
