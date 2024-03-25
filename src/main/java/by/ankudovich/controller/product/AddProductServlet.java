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
//        ProductService productService = new ProductService();
//        long code = Long.parseLong(req.getParameter("code"));
//        String name = req.getParameter("name");
//        ProductRole.PRODUCT typeOfProduct = ProductRole.PRODUCT.valueOf(req.getParameter("type"));
//        double price = Double.parseDouble(req.getParameter("price"));
//        long quantity = Long.parseLong(req.getParameter("quantity"));
//
//
//    ProductRequest product = new ProductRequest(code,name, typeOfProduct, price, quantity);
//
//    try {
//       productService.add(product);
//
//        req.getRequestDispatcher("/jsp/products/displayProducts.jsp").forward(req, resp);
//    } catch (RuntimeException e) {
//        req.setAttribute("errorMessage", e.getMessage());
//        req.getRequestDispatcher("/jsp/user/error.jsp").forward(req, resp);
//    }
//
//
//        System.out.println("Четко, есть продукт");

}
}
