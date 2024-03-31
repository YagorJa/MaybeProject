package by.ankudovich.repository.order;

import by.ankudovich.entity.Order;

import java.sql.SQLException;

public interface OrderRepository {
    Order add(Long userId, double productPrice) throws SQLException;

    Order getOrderByUserid(Long userId) throws SQLException;

    Long getCostByOrderId(Long orderId) throws SQLException;

    void updateOrderCost(Long orderId, Long newCost) throws SQLException;
}
