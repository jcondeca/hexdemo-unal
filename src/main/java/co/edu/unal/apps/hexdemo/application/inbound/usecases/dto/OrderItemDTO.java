package co.edu.unal.apps.hexdemo.application.inbound.usecases.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDTO {
    private String productId;
    private Integer quantity;
}
