package by.ankudovich.controller.product;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.enums.ProductRole;
import by.ankudovich.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductServlet extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = new ProductService();
        long code = Long.parseLong(req.getParameter("code"));
        String name = req.getParameter("name");
        ProductRole.PRODUCT typeOfProduct = ProductRole.PRODUCT.valueOf(req.getParameter("type"));
        double price = Double.parseDouble(req.getParameter("price"));
        long quantity = Long.parseLong(req.getParameter("quantity"));

    ProductRequest product = new ProductRequest(code,name, typeOfProduct, price, quantity);

    try {
       productService.add(product);

        req.getRequestDispatcher("/jsp/products/displayProducts.jsp").forward(req, resp);
    } catch (RuntimeException e) {
        req.setAttribute("errorMessage", e.getMessage());
        req.getRequestDispatcher("/jsp/user/error.jsp").forward(req, resp);
    }


        System.out.println("Четко, есть продукт");

}
}
