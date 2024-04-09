package by.ankudovich.repository.basket;

import by.ankudovich.entity.Basket;

import java.sql.SQLException;
import java.util.List;

public interface BasketRepository {
    Basket add(Long orderId, Long productId, Long count) throws SQLException;

    void makeOrder(Long userId) throws SQLException;

    List<Basket> getBasketsByOrderId(Long orderId) throws SQLException;

    void cleanBas(Long orderId, List<Long> productId, List<Long> count) throws SQLException;

    void clean();
}
