package by.ankudovich.controller;

import by.ankudovich.config.Scheduler;
import by.ankudovich.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class Init extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Scheduler.start(new OrderService());
    }
}
