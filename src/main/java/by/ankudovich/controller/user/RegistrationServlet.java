package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationServlet  {
    public void registration(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        if (login.isEmpty() || name.isEmpty() || surname.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        }
        UserRequest userRequest = new UserRequest();
        UserService userService = new UserService();
        userRequest.setLogin(login);
        userRequest.setName(name);
        userRequest.setSurname(surname);
        userRequest.setPassword(password);
        try {
            userService.register(userRequest);
            req.getRequestDispatcher("/jsp/user/user.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", "Такой пользователь уже существует!");
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     req.getRequestDispatcher("/jsp/user/registr.jsp");
//    }


//    public void registration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserFileRepository userRepository = (UserFileRepository) getServletContext().getAttribute("fileRepository");
//        UserRepository userRepository = new UserRepositoryJDBC();

//        UserService userService = new UserService();
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//
//        UserRequest userRequest = new UserRequest(name,surname,login,password);
//        try {
//            UserResponse userResponse = userService.register(userRequest);
//            req.setAttribute("user", userResponse);
//            req.getRequestDispatcher("/jsp/user/welcome.jsp").forward(req, resp);
//        } catch (RuntimeException e) {
//            req.setAttribute("errorMessage", e.getMessage());
//            req.getRequestDispatcher("/jsp/user/error.jsp").forward(req, resp);
//        }

    }
}
