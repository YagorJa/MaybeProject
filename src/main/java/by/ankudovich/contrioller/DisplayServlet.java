package by.ankudovich.contrioller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String login = (String) request.getAttribute("login");
        String password = (String) request.getAttribute("password");
        String name = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");

        out.println("<html><body>");
        out.println("<h1>Введенные данные:</h1>");
        out.println("Логин: " + login + "<br>");
        out.println("Пароль: " + password + "<br>");
        out.println("Имя: " + name + "<br>");
        out.println("Фамилия: " + surname + "<br>");
        out.println("</body></html>");
    }
}