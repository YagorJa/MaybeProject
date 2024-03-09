package by.ankudovich.controller.user;

import by.ankudovich.api.User.UserResponse;
import by.ankudovich.entity.User;
import by.ankudovich.repository.UserFileRepository;
import by.ankudovich.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserFileRepository repository;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        repository = new UserFileRepository();
        userService=new UserService(repository);
        getServletContext().setAttribute("fileRepository", userService);
    } /* вобше песня,
     чтобы объект FileRepository использовался в нескольких сервлетах без создания нового экземпляра при каждом запросе,
     можно использовать механизмы управления состоянием веб-приложения, такие как контекст сервлета (Servlet Context).

    можено создать и инициализировать экземпляр FileRepository в методе init() моего сервлета, а затем сохранить его в контексте сервлета.
    Это позволит использовать один и тот же экземпляр FileRepository во всех сервлетах вашего веб-приложения.

    Теперь repository доступен для всех сервлетов, которые могут получить к нему доступ через контекст сервлета:

    FileRepository repository = (FileRepository) getServletContext().getAttribute("fileRepository");

    Таким образом, в каждом следующем сервлете я можгу получить доступ к тому же экземпляру FileRepository, который был создан тут  мной
    */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обработка введенных данных из формы входа
        String usernameLogin = req.getParameter("username");
        String passwordLgin = req.getParameter("password");
        try {

          //  UserResponse userResponse=userService.authentication(usernameLogin,passwordLgin);
            User authentication = repository.authentication(usernameLogin, passwordLgin);// здесь лежит конкретный юзер которого я пробрасываю дальше

            // Успешная аутентификация: сохраняем идентификатор пользователя в сессии
            HttpSession session = req.getSession();
            session.setAttribute("userId", authentication.getId());

            req.setAttribute("user", authentication);
            req.getRequestDispatcher("/jsp/welcome.jsp").forward(req, resp);

        } catch (Exception exception) {
            req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }


    }
}