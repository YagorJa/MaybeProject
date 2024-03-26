package by.ankudovich.repository.order;

import by.ankudovich.entity.Order;

public interface OrderRepository {
    Order add(Long userId);

    Order getOrderByUserid(Long userId);
}
