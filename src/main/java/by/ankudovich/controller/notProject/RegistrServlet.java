//package by.ankudovich.contrioller.notProject;
//
//import by.ankudovich.entity.User;
//import by.ankudovich.repository.user.UserRepository;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.Collection;
//
//public class RegistrServlet extends HttpServlet {
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        UserRepository repository = (UserRepository) getServletContext().getAttribute("fileRepository");
//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        long id = repository.userIdGenerator();
//        User.Role role = repository.allUsers().isEmpty() ? User.Role.ADMIN : User.Role.USER;
//
//        User user = new User(id,name,surname,login,password,role);
//
//        repository.add(user);
//
//
//        request.setAttribute("login", login);
//        request.setAttribute("password", password);
//        request.setAttribute("name", name);
//        request.setAttribute("surname", surname);
//
//        // Получаем список всех пользователей
//        Collection<User> allUsers = repository.allUsers();
//
//        // Устанавливаем список всех пользователей как атрибут запроса
//        request.setAttribute("allUsers" , allUsers);
//
//        request.getRequestDispatcher("/display").forward(request, response);
//        System.out.println("Список всех пользователей: " + allUsers); //убедился что файл не пуст
//        System.out.println(repository.allUsers().size());
//
//    }
//}
