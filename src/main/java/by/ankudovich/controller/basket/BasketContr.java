package by.ankudovich.controller.basket;

import by.ankudovich.entity.User;
import by.ankudovich.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BasketContr {
    public void addOrder_Basket(HttpServletRequest req, HttpServletResponse resp) {
        String idProduct = req.getParameter("productId");
        String productCount = req.getParameter("count");
        if (idProduct == null || idProduct.isEmpty() || productCount == null || productCount.isEmpty()) {
            req.setAttribute("error", "Invalid product ID or count");
            return;
        }
        try {
            long productId = Long.parseLong(idProduct);
            long count = Long.parseLong(productCount);
            if (productId <= 0 || count <= 0) {
                req.setAttribute("error", "Invalid product ID or count");
                return;
            }
            HttpSession session = req.getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("user");
                if (user != null) {
                    OrderService orderService = new OrderService();
                    orderService.addOrderByBasket(user.getId(), productId, count);
                }
            }
            resp.sendRedirect(req.getContextPath() + "/products");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid product ID or count");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
