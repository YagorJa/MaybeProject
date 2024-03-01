package by.ankudovich.contrioller;

import by.ankudovich.entity.User;
import by.ankudovich.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserRepository repository;

    @Override
    public void init() throws ServletException {
        repository = new UserRepository();
        getServletContext().setAttribute("fileRepository", repository);
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
        req.getRequestDispatcher("jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обработка введенных данных из формы входа
        String usernameLogin = req.getParameter("username");
        String passwordLgin = req.getParameter("password");
try {

        User authentication = repository.authentication(usernameLogin,passwordLgin);
        req.setAttribute("user", authentication);
            req.getRequestDispatcher("/jsp/welcome.jsp").forward(req, resp);

}catch (Exception exception ){
    req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
}


    }
}