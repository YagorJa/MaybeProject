//package by.ankudovich.filter;
//
//import by.ankudovich.entity.User;
//import by.ankudovich.enums.UserRole;
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class Filter implements jakarta.servlet.Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        jakarta.servlet.Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        String path = httpRequest.getServletPath();
//        if (!path.startsWith("/jsp/admin/") && !path.startsWith("/jsp/client/")) {
//            chain.doFilter(request, response);
//            return;
//        }
//        User authenticatedUser = (User) httpRequest.getSession().getAttribute("authenticatedUser");
//        if (authenticatedUser == null) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/user/login.jsp");
//            return;
//        }
//        UserRole.Role userRole = authenticatedUser.getRole();
//        if (userRole == UserRole.Role.ADMIN) {
//            chain.doFilter(request, response);
//            return;
//        }
//        if (userRole == UserRole.Role.USER && path.startsWith("/jsp/admin/")) {
//            request.setAttribute("error", "У вас недостаточно прав!");
//            request.getRequestDispatcher("/jsp/user/error.jsp").forward(request, response);
//            return;
//        }
//        httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/user/error.jsp");
//    }
//
//    @Override
//    public void destroy() {
//        jakarta.servlet.Filter.super.destroy();
//    }
//
//}
