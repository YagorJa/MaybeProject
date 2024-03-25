package by.ankudovich.controller.user;

import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/authen/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService repository = (UserService) getServletContext().getAttribute("fileRepository");

        HttpSession session = req.getSession();

        Long currentId = (Long) session.getAttribute("userId");

        if (currentId != null) {   // тут я думаю мб какую то по круче проверку добавить мб, например есть ли впринципе ПОЛЬЗОВАТЕЛЬ а не его айди, буду рад предложениям по реализации


            long currentUserId = currentId;
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");

            repository.updateUser(currentUserId, name, surname, login, password);

        req.getRequestDispatcher("/jsp/authen/login.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/jsp/authen/error.jsp").forward(req, resp);
        }
    }

}