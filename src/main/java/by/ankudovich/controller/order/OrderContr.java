package by.ankudovich.controller.order;

import by.ankudovich.entity.User;
import by.ankudovich.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class OrderContr {
    public void makeOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("authenticatedUser");
            if (user != null) {
                OrderService orderService = new OrderService();
                orderService.makeOrder(user.getId());
                req.getSession().setAttribute("orderStatus", "COMPLETED");
                req.getRequestDispatcher("/jsp/user/basketF.jsp").forward(req, resp);
            }
        }
    }
}
