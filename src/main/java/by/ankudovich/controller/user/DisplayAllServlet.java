package by.ankudovich.controller.user;

import by.ankudovich.entity.User;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

public class DisplayAllServlet {
    private final UserService userService;

    public DisplayAllServlet() {
        this.userService = new UserService();
    }

    public void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<User> users = userService.allUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/jsp/admin/editUser.jsp").forward(request, response);

    }
}
