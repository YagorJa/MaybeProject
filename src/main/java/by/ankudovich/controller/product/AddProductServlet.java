package by.ankudovich.controller.product;

import by.ankudovich.entity.Product;
import by.ankudovich.enums.ProductRole;
import by.ankudovich.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        productRepository = new ProductRepository(); // или инициализация через Dependency Injection
    }

@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long code = Long.parseLong(req.getParameter("code"));
        String name = req.getParameter("name");
        ProductRole.PRODUCT typeOfProduct = ProductRole.PRODUCT.valueOf(req.getParameter("type"));
        double price = Double.parseDouble(req.getParameter("price"));
        long quantity = Long.parseLong(req.getParameter("quantity"));

        Product product = new Product(code, name, price, quantity,typeOfProduct);

        // Добавляем продукт в репозиторий
        productRepository.add(product);
        System.out.println("Четко, есть продукт");
        // Перенаправляем пользователя на страницу успешного добавления товара
        // resp.sendRedirect("/success.jsp");
    }
}
