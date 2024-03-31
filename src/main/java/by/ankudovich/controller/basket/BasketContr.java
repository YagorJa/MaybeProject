package by.ankudovich.controller.basket;

import by.ankudovich.entity.User;
import by.ankudovich.service.OrderService;
import by.ankudovich.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class BasketContr {
    public void addOrder_Basket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String idProduct = req.getParameter("idProduct");
        String productCount = req.getParameter("ProductCount");
        if (idProduct == null || idProduct.isEmpty() || productCount == null || productCount.isEmpty()) {
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("authenticatedUser");
            if (user != null) {
                OrderService orderService = new OrderService();
                ProductService productService = new ProductService();
                long productPrice = (long) productService.getProductPriceID(Long.valueOf(idProduct));
                orderService.addOrderByBasket(user.getId(), Long.valueOf(idProduct), productPrice, Long.valueOf(productCount));
                req.getRequestDispatcher("/jsp/user/products.jsp").forward(req, resp);
                return;
            }
        }
        req.setAttribute("error", "User not logged in");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
