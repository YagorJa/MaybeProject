package by.ankudovich.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogOutAdmin {
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/jsp/authen/login.jsp").forward(req, resp);
    }
}
