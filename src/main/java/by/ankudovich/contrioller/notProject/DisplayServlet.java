package by.ankudovich.contrioller.notProject;

import by.ankudovich.entity.User;
import by.ankudovich.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserRepository repository = new UserRepository();
        Collection<User> allUsers = repository.allUsers();

        // Устанавливаем список всех пользователей как атрибут запроса
        request.setAttribute("allUsers" , allUsers);
    request.getRequestDispatcher("jsp/notProject/display.jsp").forward(request,response);
    }
}