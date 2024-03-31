package by.ankudovich.api.Order;

import by.ankudovich.api.Product.ProductResponse;
import lombok.Data;

import java.util.List;
@Data

public class OrderResponse {
    private Long id;
    private Long userId;
    private Double price;
    private String status;
    List<ProductResponse> products;
}
