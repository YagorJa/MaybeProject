package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.entity.User;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class EditProfileServlet {



    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("authenticatedUser");
        if (user == null) {
            req.setAttribute("error", "Пользователь не авторизован");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        long userId = user.getId();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserRequest userRequest = new UserRequest();
        UserService userService = new UserService();
        userRequest.setId(userId);
        userRequest.setLogin(login);
        userRequest.setName(name);
        userRequest.setSurname(surname);
        userRequest.setPassword(password);
        try {
            userService.updateUser(userRequest);
            req.setAttribute("user", userRequest);
            req.getRequestDispatcher("/jsp/authen/edit.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        }
    }
}

