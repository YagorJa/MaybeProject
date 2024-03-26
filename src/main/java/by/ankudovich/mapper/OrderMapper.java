package by.ankudovich.mapper;

import by.ankudovich.api.Order.OrderResponse;
import by.ankudovich.entity.Order;

public class OrderMapper {
    public OrderResponse toResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setUserId(order.getUserId());
        orderResponse.setStatus(order.getStatus());
        return orderResponse;
    }
}
