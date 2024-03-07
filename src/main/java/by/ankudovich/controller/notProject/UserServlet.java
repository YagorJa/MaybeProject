package by.ankudovich.controller.notProject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        out.println("<html><body>");
        out.println("<h2>Привет, " + name + " " + lastName + "!</h2>");
        out.println("</body></html>");

        out.close();
    }
}
