package by.ankudovich.repository.order;

import by.ankudovich.config.JDBC;
import by.ankudovich.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryJDBC implements OrderRepository {
    JDBC connection = new JDBC();

    @Override
    public Order add(Long userId) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatementMaxId = con.prepareStatement("SELECT max(id) from project.order");
             PreparedStatement preparedStatement = con.prepareStatement(" insert into project.order(id, userId, price, status) values (?,?,?,?)")) {
            ResultSet resultSet = preparedStatementMaxId.executeQuery();
            resultSet.next();
            long maxId = resultSet.getLong(1);
            maxId++;
            double price =  resultSet.getDouble(3);
            String status = "Создан";
            preparedStatement.setLong(1, maxId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, status);
            preparedStatement.executeUpdate();
            Order order = new Order(maxId, userId,price, status);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при добавлении заказа");
        }
    }

    @Override
    public Order getOrderByUserid(Long userId) {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM project.order WHERE userid = ?");) {
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String status = resultSet.getString("status");
                order = new Order(id, userId, status);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при получении заказа по ID пользователя");
        }
    }
}