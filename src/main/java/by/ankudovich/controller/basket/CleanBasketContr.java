package by.ankudovich.controller.basket;

import by.ankudovich.entity.User;
import by.ankudovich.service.BasketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class CleanBasketContr {
    public void clean(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("orders");
            User user = (User) session.getAttribute("user");
            if (user != null) {
                BasketService basketService = new BasketService();
                basketService.cleanBasket(user.getId());
            } else {
                try {
                    resp.sendRedirect(req.getContextPath() + "/login.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
    }
}
