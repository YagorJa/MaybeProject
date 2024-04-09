package by.ankudovich.controller.basket;

import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.service.BasketService;
import by.ankudovich.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class CleanBasketContr {
    public void clean(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            UserResponse user = (UserResponse) session.getAttribute("authenticatedUser");
            if (user != null) {
                BasketService basketService = new BasketService();
                basketService.cleanBas(user.getId());
                session.getAttribute("orders");
                req.getRequestDispatcher("/jsp/user/products.jsp").forward(req, resp);
            }
        }
    }
}