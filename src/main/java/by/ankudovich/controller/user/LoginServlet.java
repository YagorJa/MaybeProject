package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.enums.UserRole;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet  {


    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            req.setAttribute("errorMessage", "Вы вобще нихуя не ввели");
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        }
        UserRequest userRequest = new UserRequest();
        userRequest.setLogin(login);
        userRequest.setPassword(password);
        UserService userService = new UserService();
        UserResponse authenticate = userService.authentication(login, password);
        if (authenticate == null) {
            req.getRequestDispatcher("/jsp/authen/register.jsp").forward(req, resp);
        }
        if (authenticate.equals(new UserResponse())) {
            req.setAttribute("errorMessage", "Вы ввели неверный пароль, но логин верный");
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req,resp);
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("authenticatedUser", authenticate);
        assert authenticate != null;
        if (authenticate.getRole().equals(UserRole.Role.ADMIN)) {
            req.getRequestDispatcher("/jsp/admin/admin.jsp").forward(req, resp);
        } else {
            req.setAttribute("user", authenticate);
            req.getRequestDispatcher("/jsp/user/user.jsp").forward(req, resp);


        }
    }
}