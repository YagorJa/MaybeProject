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
    public Order add(Long userId, double productPrice) throws SQLException {
        Connection con = connection.getConnection();
        PreparedStatement preparedStatementMaxId = con.prepareStatement("SELECT max(id) from project.order");
        ResultSet resultSet = preparedStatementMaxId.executeQuery();
        resultSet.next();
        long maxId = resultSet.getLong(1);
        maxId++;
        PreparedStatement preparedStatement = con.prepareStatement(" insert into project.order(id, userId, cost, status)  " + "values (?,?,?,?)");
        String status = "ORDERING";
        preparedStatement.setLong(1, maxId);
        preparedStatement.setLong(2, userId);
        preparedStatement.setDouble(3, productPrice);
        preparedStatement.setString(4, status);
        preparedStatement.executeUpdate();
        return new Order(maxId, userId, productPrice, status);
    }

    @Override
    public Order getOrderByUserid(Long userId) throws SQLException {
        Connection con = connection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM project.order WHERE userid = ? AND status = 'ORDERING'");
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Order order = new Order();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            Long userid = resultSet.getLong("userid");
            Double productPrice = resultSet.getDouble("cost");
            String status = resultSet.getString("status");
            order.setId(id);
            order.setUserId(userid);
            order.setPrice(productPrice);
            order.setStatus(status);
        }
        return order;
    }

    public Long getCostByOrderId(Long orderId) throws SQLException {
        Connection con = connection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("SELECT cost FROM project.order WHERE id = ?");
        preparedStatement.setLong(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Long orderCost = null;
        if (resultSet.next()) {
            orderCost = resultSet.getLong("cost");
        }
        return orderCost;
    }

    @Override
    public void updateOrderCost(Long orderId, Long newCost) throws SQLException {
        Connection con = connection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("UPDATE project.order SET cost = ? WHERE id = ?");
        preparedStatement.setLong(1, newCost);
        preparedStatement.setLong(2, orderId);
        preparedStatement.executeUpdate();
    }
}