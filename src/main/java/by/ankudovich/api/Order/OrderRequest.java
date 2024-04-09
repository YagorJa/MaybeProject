package by.ankudovich.api.Order;

import lombok.Data;

@Data
public class OrderRequest {
    private Long id;
    private Long userId;
    private Long cost;
    private String status;
}
