package by.ankudovich.controller.order;

import by.ankudovich.entity.User;
import by.ankudovich.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class OrderContr {
    public void makeOrder(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                OrderService orderService = new OrderService();
                orderService.makeOrder(user.getId());
                try {
                    req.getRequestDispatcher("/jsp/client/products.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    resp.sendRedirect(req.getContextPath() + "/login.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
