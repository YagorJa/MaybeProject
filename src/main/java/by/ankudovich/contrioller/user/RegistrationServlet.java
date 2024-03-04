package by.ankudovich.contrioller.user;

import by.ankudovich.entity.User;
import by.ankudovich.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
        UserRepository repository = (UserRepository) getServletContext().getAttribute("fileRepository");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        long id = repository.userIdGenerator();
        User.Role role = repository.allUsers().isEmpty() ? User.Role.ADMIN : User.Role.USER;

        User user = new User(id,name,surname,login,password,role);
        repository.add(user);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/welcome").forward(req, resp);
        //resp.sendRedirect("/welcome");
    }
}
