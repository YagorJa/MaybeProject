package by.ankudovich.controller.product;

import by.ankudovich.api.Product.ProductResponse;
import by.ankudovich.entity.Product;
import by.ankudovich.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FindProductServlet extends HttpServlet {
    private ProductService productService;

    public FindProductServlet() {
        this.productService = new ProductService();
    }

    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(productService ==null)

        {
            productService = new ProductService();
            getServletContext().setAttribute("ProductRepository", productService);
        }

        long productId = Long.parseLong(req.getParameter("productId"));


        ProductResponse product = productService.getProductById(productId);


        req.setAttribute("product", product);


        req.getRequestDispatcher("/jsp/admin/productDetails.jsp").forward(req, resp);
    }
    public void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String productName = request.getParameter("productName");
            String productIdStr = request.getParameter("productId");
            if (productName != null && !productName.isEmpty()) {
                ProductResponse productResponse = productService.getProductByName(productName);
                if (productResponse != null) {
                    request.setAttribute("product", productResponse);
                } else {
                    request.setAttribute("searchResult", "Продукт с указанным именем не найден");
                }
            } else if (productIdStr != null && !productIdStr.isEmpty()) {
                long productId = Long.parseLong(productIdStr);
                ProductResponse productResponse = productService.getProductById(productId);
                if (productResponse != null) {
                    request.setAttribute("product", productResponse);
                } else {
                    request.setAttribute("searchResult", "Продукт с указанным ID не найден");
                }
            } else {
                request.setAttribute("searchResult", "Введите имя продукта или ID для поиска");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("searchResult", "Некорректный формат ID продукта");
        }
        request.getRequestDispatcher("/jsp/admin/findProduct.jsp").forward(request, response);
    }
}
