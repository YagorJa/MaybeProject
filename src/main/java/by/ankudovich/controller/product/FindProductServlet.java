package by.ankudovich.controller.product;

import by.ankudovich.entity.Product;
import by.ankudovich.repository.product.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FindProductServlet extends HttpServlet {
    private ProductRepository productRepository;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(productRepository == null) {
            productRepository = new ProductRepository();
            getServletContext().setAttribute("ProductRepository", productRepository);
        }

        long productId = Long.parseLong(req.getParameter("productId"));
        Product product = productRepository.findProduct(productId);

        req.setAttribute("product", product);
        req.getRequestDispatcher("/jsp/products/productDetails.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(productRepository ==null)

    {
        productRepository = new ProductRepository();
        getServletContext().setAttribute("ProductRepository", productRepository);
    }

        long productId = Long.parseLong(req.getParameter("productId"));


        Product product = productRepository.findProduct(productId);


        req.setAttribute("product", product);


        req.getRequestDispatcher("/jsp/products/productDetails.jsp").forward(req, resp);
    }
}
