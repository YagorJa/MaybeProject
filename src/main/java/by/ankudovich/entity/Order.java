package by.ankudovich.entity;

import lombok.Data;

@Data

public class Order {
    private Long id;
    private Long userId;
    private Double price;
    private String status;

    public Order(long maxId, Long userId,Double price , String status) {
        this.id = maxId;
        this.userId = userId;
        this.price = price;
        this.status = status;
    }


    public Order() {
    }
}
