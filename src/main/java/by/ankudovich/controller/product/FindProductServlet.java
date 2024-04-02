package by.ankudovich.controller.product;

import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;
import by.ankudovich.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FindProductServlet {
    private ProductService productService;

    public FindProductServlet() {
        this.productService = new ProductService();
    }

    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String productName = req.getParameter("productName");
            String productIdStr = req.getParameter("productId");
            if (productName != null && !productName.isEmpty()) {
                ProductResponse productResponse = productService.getProductByName(productName);
                if (productResponse != null) {
                    req.setAttribute("product", productResponse);
                } else {
                    req.setAttribute("searchResult", "Продукт с указанным именем не найден");
                }
            } else if (productIdStr != null && !productIdStr.isEmpty()) {
                long productId = Long.parseLong(productIdStr);
                ProductResponse productResponse = productService.getProductById(productId);
                if (productResponse != null) {
                    req.setAttribute("product", productResponse);
                } else {
                    req.setAttribute("searchResult", "Продукт с указанным ID не найден");
                }
            } else {
                req.setAttribute("searchResult", "Введите имя продукта или ID для поиска");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("searchResult", "Некорректный формат ID продукта");
        }
        req.getRequestDispatcher("/jsp/admin/productDetails.jsp").forward(req, resp);
    }
}