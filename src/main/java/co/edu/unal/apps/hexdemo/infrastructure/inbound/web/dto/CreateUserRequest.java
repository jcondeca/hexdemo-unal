package co.edu.unal.apps.hexdemo.infrastructure.inbound.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String email;
    private Double maxOrderPrice;
}
