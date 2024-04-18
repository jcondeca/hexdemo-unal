package co.edu.unal.apps.hexdemo.infrastructure.outbound.persistence.sql.entity;

import co.edu.unal.apps.hexdemo.domain.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserSQLEntity {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Double maxOrderPrice;

    public static UserSQLEntity fromUser(User user) {
        UserSQLEntity userSQLEntity = new UserSQLEntity();
        userSQLEntity.setId(user.getId());
        userSQLEntity.setName(user.getName());
        userSQLEntity.setEmail(user.getEmail());
        userSQLEntity.setMaxOrderPrice(user.getMaxPriceOrder());
        return userSQLEntity;
    }

    public User toUser() {
        User user = new User(this.id);
        user.initializeUser(this.name, this.email, this.maxOrderPrice);
        return user;
    }
}
