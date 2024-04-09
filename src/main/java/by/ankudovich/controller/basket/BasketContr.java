package by.ankudovich.controller.basket;

import by.ankudovich.api.User.UserResponse;
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
    private final OrderService orderService;
    private final ProductService productService;

    public BasketContr() {
        this.orderService = new OrderService();
        this.productService = new ProductService();
    }

    public void addOrder_Basket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("idProduct");
        String productCount = req.getParameter("ProductCount");
        if (idProduct == null || idProduct.isEmpty() || productCount == null || productCount.isEmpty()) {
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession(false);
        if (session == null) {
            req.setAttribute("error", "User not logged in");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        UserResponse user = (UserResponse) session.getAttribute("authenticatedUser");
        if (user == null) {
            req.setAttribute("error", "User not logged in");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        try {
            long productPrice = (long) productService.getProductPriceID(Long.valueOf(idProduct));
            orderService.addOrderByBasket(user.getId(), Long.valueOf(idProduct), productPrice, Double.valueOf((productCount)));
            req.getRequestDispatcher("/jsp/user/products.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error", "An error occurred while processing your request.");
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        }
}
}