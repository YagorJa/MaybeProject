package by.ankudovich.controller.user;

import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteServlet {
    private final UserService userService;

    public DeleteServlet() {
        this.userService = new UserService();
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long id = Long.parseLong(request.getParameter("deleteUser"));
            userService.deleteUserById(id);
            request.setAttribute("message", "Пользователь успешно удален!");
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Некорректный  ID");
        }
        request.getRequestDispatcher("/jsp/admin/deleteUser.jsp").forward(request, response);

    }
}
