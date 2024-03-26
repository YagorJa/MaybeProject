package by.ankudovich.repository.basket;

import by.ankudovich.entity.Basket;

import java.util.List;

public interface BasketRepository {
    Basket add(Long orderId, Long productId, Long count);

    void makeOrder(Long userId);

    List<Basket> getBasketsByOrderId(Long orderId);

     default void clean(Long orderId, List<Long> productId, List<Long> count) {
    }
}
