package by.ankudovich.config;

import by.ankudovich.service.OrderService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private static boolean isStarted = false;
    private static ScheduledExecutorService scheduler;

    public static void start(OrderService orderService) {
        if (!isStarted) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
            // Установка интервала на 12 часов (12 * 60 минут * 60 секунд * 1000 миллисекунд)
            scheduler.scheduleAtFixedRate(orderService::clean, 0, 12 * 60 * 60 * 1000, TimeUnit.MILLISECONDS);
            isStarted = true;
        }
    }
}

