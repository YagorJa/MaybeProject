package by.ankudovich.api.Basket;

import lombok.Data;

@Data
public class BasketResponse {
    private Long id;
    private Long productId;
    private Long orderId;
    private Long count;
}
