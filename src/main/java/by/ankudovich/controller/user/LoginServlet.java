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
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getAttribute("fileRepository");

        // Обработка введенных данных из формы входа
        String usernameLogin = req.getParameter("username");
        String passwordlogin = req.getParameter("password");
        try {
            UserResponse authentication =  userService.authentication(usernameLogin,passwordlogin);// здесь лежит конкретный юзер которого я пробрасываю дальше


            // Успешная аутентификация: сохраняем идентификатор пользователя в сессии
            HttpSession session = req.getSession();
            session.setAttribute("userId", authentication.getId());

            req.setAttribute("user", authentication);
            req.getRequestDispatcher("/jsp/user/welcome.jsp").forward(req, resp);

        } catch (Exception exception) {
            req.getRequestDispatcher("/jsp/user/error.jsp").forward(req, resp);
        }


    }
}