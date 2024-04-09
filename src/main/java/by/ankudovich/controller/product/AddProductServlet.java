package by.ankudovich.controller.product;

import by.ankudovich.api.Product.ProductRequest;
import by.ankudovich.enums.ProductRole;
import by.ankudovich.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductServlet  {
    private final ProductService productService;

    public AddProductServlet() {
        this.productService = new ProductService();
    }


    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductRequest productRequest = new ProductRequest();
        productRequest.setNameOfProduct(req.getParameter("name"));
        productRequest.setCodeOfProduct(Long.valueOf(req.getParameter("code")));
        productRequest.setTypeOfProduct(ProductRole.PRODUCT.valueOf(req.getParameter("type")));
        productRequest.setPrice(Double.parseDouble(req.getParameter("price")));
        productRequest.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        productService.add(productRequest);
        req.setAttribute("message", "Товар  добавлен");
        req.getRequestDispatcher("/jsp/admin/addProduct.jsp").forward(req, resp);

}
}
