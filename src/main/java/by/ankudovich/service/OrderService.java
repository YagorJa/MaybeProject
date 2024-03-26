package by.ankudovich.service;

import by.ankudovich.api.Basket.BasketResponse;
import by.ankudovich.api.Order.OrderResponse;
import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Basket;
import by.ankudovich.entity.Order;
import by.ankudovich.mapper.BasketMapper;
import by.ankudovich.mapper.OrderMapper;
import by.ankudovich.repository.basket.BasketRepository;
import by.ankudovich.repository.basket.BasketRepositoryJDBC;
import by.ankudovich.repository.order.OrderRepository;
import by.ankudovich.repository.order.OrderRepositoryJDBC;

import java.util.List;

public class OrderService {

    public OrderResponse addUserByOrder(Long userId) {
        OrderRepository repository = new OrderRepositoryJDBC();
        OrderMapper orderMapper = new OrderMapper();
        Order order = repository.add(userId);
        return orderMapper.toResponse(order);
    }


    public BasketResponse addOrderByBasket(Long userId, Long productId, Long count) {
        OrderRepository orderRepository = new OrderRepositoryJDBC();
        Order orderByUserid = orderRepository.getOrderByUserid(userId);
        Long id = 0L;
        if (orderByUserid.getUserId() == userId && orderByUserid.getUserId() != null && orderByUserid.getStatus().equals("Создан")) {
            id = orderByUserid.getId();
        } else {
            OrderResponse orderResponse = addUserByOrder(userId);
            id = orderResponse.getId();
        }
        BasketRepository repository = new BasketRepositoryJDBC();
        if (id == 0 || productId == 0 || count == 0) {
            throw new RuntimeException("Неверные значения в полях");
        }
        Basket basket = repository.add(id, productId, count);

        BasketMapper basketMapper = new BasketMapper();
        return basketMapper.toResponse(basket);
    }


    public void makeOrder(Long userId) {
        BasketRepository repository = new BasketRepositoryJDBC();
        repository.makeOrder(userId);
    }


    public OrderResponse allOrders(Long userId) {
        OrderRepository orderJDBCRepository = new OrderRepositoryJDBC();
        Order orderByUserid = orderJDBCRepository.getOrderByUserid(userId);
        BasketRepository basketRepository = new BasketRepositoryJDBC();
        Long getOrderId = 0L;
        if (orderByUserid.getStatus().equals("Создан")) {
            getOrderId = orderByUserid.getId();
        }
        if (getOrderId == null) {
            throw new RuntimeException("Корзина пустая");
        }
        List<Basket> basketsByOrderId = basketRepository.getBasketsByOrderId(getOrderId);
        List<Long> listProductId = basketsByOrderId.stream().map(basket -> basket.getProductId()).toList();
        ProductService productService = new ProductService();
        List<ProductResponse> productsByIds = productService.getProductsByIds(listProductId);
        OrderMapper orderMapper = new OrderMapper();
        OrderResponse orderResponse = orderMapper.toResponse(orderByUserid);
        orderResponse.setProducts(productsByIds);
        return orderResponse;
    }
}
