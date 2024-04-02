package by.ankudovich.controller.order;

import by.ankudovich.api.Order.OrderResponse;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class AllOrderContr {
    public void allOrders(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            UserResponse user = (UserResponse) session.getAttribute("authenticatedUser");
            if (user != null) {
                OrderService orderService = new OrderService();
                try {
                    OrderResponse orderResponse = orderService.allOrders(user.getId());
                    session.setAttribute("orders", orderResponse);
                    session.setAttribute("orderStatus", orderResponse.getStatus());
                    Long orderCost = orderService.getOrderCostById(orderResponse.getId());
                    req.setAttribute("orderCost", orderCost);
                    req.setAttribute("orderId", orderResponse.getId());
                    req.getRequestDispatcher("/jsp/user/basket.jsp").forward(req, resp);
                } catch (RuntimeException e) {
                    req.setAttribute("error", "Корзина пустая");
                    req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
                }
            }
        }
    }
}
