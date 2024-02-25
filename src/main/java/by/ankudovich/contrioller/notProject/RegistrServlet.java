package by.ankudovich.contrioller.notProject;

import by.ankudovich.entity.User;
import by.ankudovich.repository.FileRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

public class RegistrServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = new User(1l,name,surname,login,password);

        FileRepository repository = new FileRepository();
        repository.add(user);


        request.setAttribute("login", login);
        request.setAttribute("password", password);
        request.setAttribute("name", name);
        request.setAttribute("surname", surname);

        // Получаем список всех пользователей
        Collection<User> allUsers = repository.allUsers();

        // Устанавливаем список всех пользователей как атрибут запроса
        request.setAttribute("allUsers" , allUsers);

        request.getRequestDispatcher("/display").forward(request, response);
        System.out.println("Список всех пользователей: " + allUsers); //убедился что файл не пуст
        System.out.println(repository.allUsers().size());

    }
}
