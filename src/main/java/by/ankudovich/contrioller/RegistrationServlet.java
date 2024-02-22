package by.ankudovich.contrioller;

import by.ankudovich.entity.User;
import by.ankudovich.repository.FileRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
//
//        User user = new User(1l,name,surname,login,password);
//
//        FileRepository repository = new FileRepository();
//        repository.add(user);
//
        try (FileWriter writer = new FileWriter("C:\\tms\\TempDz4\\src\\main\\resources\\file.ser", true)) {
            writer.write("Login: " + login + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Surname: " + surname + "\n");
            writer.write("-------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setAttribute("login", login);
        request.setAttribute("password", password);
        request.setAttribute("name", name);
        request.setAttribute("surname", surname);

        request.getRequestDispatcher("/display").forward(request, response);
    }
}
