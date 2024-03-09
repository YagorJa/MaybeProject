package by.ankudovich.controller.product;

import by.ankudovich.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    private ProductRepository productRepository;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (productRepository == null) {
            productRepository = new ProductRepository();
            getServletContext().setAttribute("ProductRepository", productRepository);
        }
        long id = Long.parseLong(req.getParameter("id"));


        productRepository.deleteProductById(id);


      //  resp.sendRedirect("/success.jsp");
    }
}