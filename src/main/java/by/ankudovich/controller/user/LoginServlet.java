package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.enums.UserRole;
import by.ankudovich.repository.user.UserRepository;
import by.ankudovich.repository.user.UserRepositoryJDBC;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet  {


    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
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
        HttpSession session = req.getSession(true);
        session.setAttribute("authenticatedUser", authenticate);
        assert authenticate != null;
        if (authenticate.getRole().equals(UserRole.Role.ADMIN)) {
            req.getRequestDispatcher("/jsp/admin/admin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/jsp/user/user.jsp").forward(req, resp);

//        getServletContext().getAttribute("fileRepository");


//        String usernameLogin = req.getParameter("login");
//        String passwordlogin = req.getParameter("password");
//        try {
//
//            UserResponse authentication =  userService.authentication(usernameLogin,passwordlogin);// здесь лежит конкретный юзер которого я пробрасываю дальше
//
//
//            // Успешная аутентификация: сохраняем идентификатор пользователя в сессии
//            HttpSession session = req.getSession();
//            session.setAttribute("userId", authentication.getId());
//
//            req.setAttribute("user", authentication);
//            req.getRequestDispatcher("/jsp/authen/welcome.jsp").forward(req, resp);
//
//        } catch (Exception exception) {
//            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
//        }
//
//
        }
    }
}