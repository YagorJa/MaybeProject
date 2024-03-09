package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserRequest;
import by.ankudovich.api.User.UserResponse;
import by.ankudovich.enums.UserRole;
import by.ankudovich.entity.User;
import by.ankudovich.repository.UserFileRepository;
import by.ankudovich.repository.UserRepository;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.getRequestDispatcher("/jsp/registr.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserFileRepository repository = (UserFileRepository) getServletContext().getAttribute("fileRepository");
        UserRepository userRepository = new UserFileRepository();

        // Передача UserRepository в конструктор UserService
        UserService userService = new UserService(userRepository);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

//        long id = repository.userIdGenerator();
//        UserRole.Role role = repository.allUsers().isEmpty() ? UserRole.Role.ADMIN : UserRole.Role.USER;

//        User user = new User(name,surname,login,password,role);
        UserRequest userRequest = new UserRequest(name,surname,login,password);
        UserResponse userResponse=userService.register(userRequest);

        req.setAttribute("user", userResponse);
        req.getRequestDispatcher("/jsp/welcome.jsp").forward(req, resp);
    }
}