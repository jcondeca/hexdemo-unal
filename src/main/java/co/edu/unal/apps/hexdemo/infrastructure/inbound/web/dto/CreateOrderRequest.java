package co.edu.unal.apps.hexdemo.infrastructure.inbound.web.dto;

import co.edu.unal.apps.hexdemo.application.inbound.usecases.dto.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private String userId;
    private List<OrderItemDTO> items;
}
