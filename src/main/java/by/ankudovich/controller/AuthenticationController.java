package by.ankudovich.controller;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.enums.UserRole;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationController {
    public void authentication(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("/jsp/user/error.jsp").forward(req, resp);
        }
//        UserRequest userRequest = new UserRequest();
//        User userRequest = null;
//        userRequest.setLogin(login);
//        userRequest.setPassword(password);
        UserService userService = new UserService();
        UserResponse authenticate = userService.authentication(login,password);
        if (authenticate == null) {
            req.getRequestDispatcher("/jsp/user/register.jsp").forward(req, resp);
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("authenticatedUser", authenticate);
        assert authenticate != null;
        if (authenticate.getRole().equals(UserRole.Role.ADMIN)) {
            req.getRequestDispatcher("/jsp/user/admin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/jsp/client/client.jsp").forward(req, resp);
        }
    }
}
