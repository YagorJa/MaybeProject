package by.ankudovich.controller;




import by.ankudovich.controller.product.*;
import by.ankudovich.controller.user.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/registr".equals(path)) {
            RegistrationServlet registrationServlet = new RegistrationServlet();
            registrationServlet.registration(request, response);
        }
        if ("/login".equals(path)) {
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.login(request, response);
        }
        if ("/addProduct".equals(path)) {
            AddProductServlet addProductServlet = new AddProductServlet();
            addProductServlet.add(request, response);
        }
        if ("/deleteProduct".equals(path)) {
            DeleteProductServlet deleteProductServlet = new DeleteProductServlet();
            deleteProductServlet.delete(request, response);
        }
        if ("/find".equals(path)) {
            FindProductServlet findProductServlet = new FindProductServlet();
            findProductServlet.find(request, response);
        }

        if ("/editProducts".equals(path)) {
            DisplayAllProducts displayAllProducts = new DisplayAllProducts();
            displayAllProducts.showAllProducts(request, response);
        }
        if ("/editUsers".equals(path)) {
            DisplayAllServlet displayAllServlet = new DisplayAllServlet();
            displayAllServlet.showAllUsers(request, response);
        }
        if ("/deleteuser".equals(path)) {
            DeleteServlet deleteServlet = new DeleteServlet();
            deleteServlet.delete(request, response);
        }
        if ("/finduser".equals(path)) {
            FindUserServlet findUserServlet = new FindUserServlet();
            findUserServlet.findUser(request, response);
        }
        if ("/admin".equals(path)) {
            LogOutAdmin logOutAdmin = new LogOutAdmin();
            logOutAdmin.logout(request, response);
        }
        if ("/user".equals(path)) {
            LogOutUser logOutUser = new LogOutUser();
            logOutUser.logoutUser(request, response);
        }
        if ("/products".equals(path)) {
            DisplayProductsUser showProductsClientController = new DisplayProductsUser();
            showProductsClientController.showProducts(request, response);
        }

    }
}
