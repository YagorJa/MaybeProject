package by.ankudovich.controller.product;

import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;
import by.ankudovich.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class DisplayProductsUser {
    private final ProductService productService;

    public DisplayProductsUser() {
        this.productService = new ProductService();
    }
    public void showProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductResponse> products = productService.allProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/user/products.jsp");
        dispatcher.forward(request, response);
    }
}
