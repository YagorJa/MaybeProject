package by.ankudovich.filter;

import by.ankudovich.entity.User;
import by.ankudovich.enums.UserRole;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Filter implements jakarta.servlet.Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String path = httpServletRequest.getServletPath();
        if (!path.startsWith("/jsp/admin/") && !path.startsWith("/jsp/user/")) {
            chain.doFilter(request, response);
            return;
        }

        User authenticatedUser = (User) httpServletRequest.getSession().getAttribute("authenticatedUser");
        if (authenticatedUser == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/jsp/authen/login.jsp");
            return;
        }
        UserRole.Role userRole = authenticatedUser.getRole();
        if (userRole == UserRole.Role.ADMIN) {
            chain.doFilter(request, response);
            return;
        }
        if (userRole == UserRole.Role.USER && path.startsWith("/jsp/admin/")) {
            request.setAttribute("error", "У вас недостаточно прав!");
            request.getRequestDispatcher("/jsp/authen/error.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);

    }
}