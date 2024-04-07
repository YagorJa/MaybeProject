package by.ankudovich.controller;


import by.ankudovich.controller.basket.BasketContr;
import by.ankudovich.controller.basket.CleanBasketContr;
import by.ankudovich.controller.order.AllOrderContr;
import by.ankudovich.controller.order.OrderContr;
import by.ankudovich.controller.product.*;
import by.ankudovich.controller.user.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

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
        if ("/editProfile".equals(path)) {
            EditProfileServlet editProfileServlet = new EditProfileServlet();
            editProfileServlet.edit(request, response);
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
        if ("/products".equals(path) && request.getParameter("showproducts") != null) {
            DisplayProductsUser displayProductsUser = new DisplayProductsUser();
            displayProductsUser.showProducts(request, response);
        }
        if ("/products".equals(path) && request.getParameter("addProductByBasket") != null) {
            BasketContr basketContr = new BasketContr();
            basketContr.addOrder_Basket(request, response);
        }
        if ("/basket".equals(path) && request.getParameter("basket") != null) {
            AllOrderContr allOrderContr = new AllOrderContr();
            try {
                allOrderContr.allOrders(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if ("/basket".equals(path) && request.getParameter("makeOrder") != null) {
            OrderContr orderContr = new OrderContr();
            try {
                orderContr.makeOrder(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if ("/basket".equals(path) && request.getParameter("cleanBasket") != null) {
            CleanBasketContr basketController = new CleanBasketContr();
            try {
                basketController.clean(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
