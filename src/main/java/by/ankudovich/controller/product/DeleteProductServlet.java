package by.ankudovich.controller.product;

import by.ankudovich.repository.product.ProductRepository;
import by.ankudovich.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteProductServlet {
        private final ProductService productService;

        public DeleteProductServlet() {
            this.productService = new ProductService();
        }

        public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                long productId = Long.parseLong(request.getParameter("deleteProductId"));
                if (productService.getProductById(productId) != null) {
                    request.setAttribute("message", "Продукта с таким ID не существует");
                } else {
                    productService.deleteProduct(productId);
                    request.setAttribute("message", "Товар успешно удален");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Некорректный Product ID");
            }
            request.getRequestDispatcher("/jsp/admin/deleteProduct.jsp").forward(request, response);
        }
}
