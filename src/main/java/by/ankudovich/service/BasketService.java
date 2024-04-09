package by.ankudovich.service;

import by.ankudovich.entity.Basket;
import by.ankudovich.entity.Order;
import by.ankudovich.repository.basket.BasketRepository;
import by.ankudovich.repository.basket.BasketRepositoryJDBC;
import by.ankudovich.repository.order.OrderRepository;
import by.ankudovich.repository.order.OrderRepositoryJDBC;

import java.sql.SQLException;
import java.util.List;

public class BasketService {
    public void cleanBas(Long userId) throws SQLException {
        OrderRepository orderRepositoryJDBC = new OrderRepositoryJDBC();
        Order orderByUserid = orderRepositoryJDBC.getOrderByUserid(userId);
        BasketRepository basketRepository = new BasketRepositoryJDBC();
        Long getOrderId = orderByUserid.getId();
        List<Basket> basketsByOrderId = basketRepository.getBasketsByOrderId(getOrderId);
        List<Long> listProductId = basketsByOrderId.stream().map(basket -> basket.getProductId()).toList();
        List<Long> listCount = basketsByOrderId.stream().map(Basket::getCount).toList();
        basketRepository.cleanBas(getOrderId, listProductId, listCount);
    }
    public void clean() {
        BasketRepository basketRepository = new BasketRepositoryJDBC();
        basketRepository.clean();
    }
}
