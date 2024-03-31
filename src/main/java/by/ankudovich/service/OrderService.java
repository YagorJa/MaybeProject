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

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    public OrderResponse addUserByOrder(Long userId, Long productPrice) throws SQLException {
        OrderRepository repository = new OrderRepositoryJDBC();
        OrderMapper orderMapper = new OrderMapper();
        Order order = repository.add(userId, productPrice);
        return orderMapper.toResponse(order);
    }


    public BasketResponse addOrderByBasket(Long userId, Long productId, Long count, Long productPrice) throws SQLException {
        OrderRepository orderRepository = new OrderRepositoryJDBC();
        Order orderByUserId = orderRepository.getOrderByUserid(userId);
        if (orderByUserId.getId() == null || !orderByUserId.getStatus().equals("ORDERING")) {
            addUserByOrder(userId, productPrice * count);
            orderByUserId = orderRepository.getOrderByUserid(userId);
        } else {
            orderRepository.updateOrderCost(orderByUserId.getId(), (long) (orderByUserId.getPrice() + productPrice * count));
        }
        Long orderId = orderByUserId.getId();
        BasketRepository repository = new BasketRepositoryJDBC();
        if (orderId == null || productId == 0 || count == 0) {
            throw new RuntimeException("Неправильные значения в полях");
        }
        Basket basket = repository.add(orderId, productId, count);
        BasketMapper basketMapper = new BasketMapper();
        return basketMapper.toResponse(basket);
    }


    public void makeOrder(Long userId) throws SQLException {
        BasketRepository repository = new BasketRepositoryJDBC();
        repository.makeOrder(userId);
    }


    public OrderResponse allOrders(Long userId) throws SQLException {
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
    public void cleanBasket(Long userId) throws SQLException {
        OrderRepository orderRepositoryJDBC = new OrderRepositoryJDBC();
        Order orderByUserid = orderRepositoryJDBC.getOrderByUserid(userId);
        BasketRepository basketRepository = new BasketRepositoryJDBC();
        Long getOrderId = orderByUserid.getId();
        List<Basket> basketsByOrderId = basketRepository.getBasketsByOrderId(getOrderId);
        List<Long> listProductId = basketsByOrderId.stream().map(basket -> basket.getProductId()).toList();
        List<Long> listCount = basketsByOrderId.stream().map(Basket::getCount).toList();
        basketRepository.cleanBas(getOrderId, listProductId, listCount);
    }
    public Long getOrderCostById(Long orderId) throws SQLException {
        OrderRepository repository = new OrderRepositoryJDBC();
        return repository.getCostByOrderId(orderId);
    }
    public void clean() {
        BasketRepository basketRepository = new BasketRepositoryJDBC();
        basketRepository.clean();
    }
}
