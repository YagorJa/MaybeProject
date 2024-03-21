package by.ankudovich.controller.product;

import by.ankudovich.entity.Product;
import by.ankudovich.repository.product.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class DisplayProdcutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductRepository productRepository = new ProductRepository();
        List<Product> allProducts = productRepository.allProducts();

        // Устанавливаем список всех пользователей как атрибут запроса
        request.setAttribute("allProducts", allProducts);
        request.getRequestDispatcher("jsp/products/displayProducts.jsp").forward(request, response);
    }
}