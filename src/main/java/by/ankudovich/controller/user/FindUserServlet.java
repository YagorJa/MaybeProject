package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserResponse;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FindUserServlet {
    private final UserService userService;

    public FindUserServlet() {
        this.userService = new UserService();
    }

    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userLogin = request.getParameter("userLogin");
            String userIdStr = request.getParameter("userId");
            if (userLogin != null && !userLogin.isEmpty()) {
                UserResponse userResponse = userService.getUserByLogin(userLogin);
                if (userResponse != null) {
                    request.setAttribute("user", userResponse);
                } else {
                    request.setAttribute("searchResult", "Юзер с указанным именем не найден");
                }
            } else if (userIdStr != null && !userIdStr.isEmpty()) {
                long useId = Long.parseLong(userIdStr);
                UserResponse userResponse = userService.getUserById(useId);
                if (userResponse != null) {
                    request.setAttribute("user", userResponse);
                } else {
                    request.setAttribute("searchResult", "Пользователь с указанным ID не найден");
                }
            } else {
                request.setAttribute("searchResult", "Введите логин пользователя или ID для поиска");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("searchResult", "Некорректный формат ID пользователя");
        }
        request.getRequestDispatcher("/jsp/admin/findUser.jsp").forward(request, response);
    }
}
