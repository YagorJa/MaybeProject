package by.ankudovich.repository.basket;

import by.ankudovich.config.JDBC;
import by.ankudovich.entity.Basket;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BasketRepositoryJDBC implements BasketRepository {
        JDBC connection = new JDBC();

    @Override
    public Basket add(Long orderId, Long productId, Long count) {
        try (Connection connect = connection.getConnection();
             PreparedStatement preparedStatementMax = connect.prepareStatement("select max(id) from project.basket");
             ResultSet resultSet = preparedStatementMax.executeQuery()) {
            resultSet.next();
            long maxId = resultSet.getLong(1);
            try (PreparedStatement preparedStatement = connect.prepareStatement(" insert into project.basket(id, productid, orderid, count) values (?,?,?,?)")) {
                preparedStatement.setLong(1, ++maxId);
                preparedStatement.setLong(2, orderId);
                preparedStatement.setLong(3, productId);
                preparedStatement.setLong(4, count);
                preparedStatement.executeUpdate();
            }
            PreparedStatement quantity = connect.prepareStatement("SELECT quantity from project.product WHERE id = ?");
            quantity.setLong(1, productId);
            ResultSet executeQuery = quantity.executeQuery();
            executeQuery.next();
            long quantityLong = executeQuery.getLong(1);
            if (quantityLong < 1) {
                throw new RuntimeException("Товар отсутсвует");
            }
            PreparedStatement preparedStatementCount = connect.prepareStatement("UPDATE project.product SET quantity = ? where id = ?");
            preparedStatementCount.setLong(1, quantityLong - count);
            preparedStatementCount.setLong(2, productId);
            preparedStatementCount.executeUpdate();
            Basket basket = new Basket();
            basket.setId(maxId);
            basket.setOrderId(orderId);
            basket.setProductId(productId);
            basket.setCount(count);

            return basket;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при добавлении товара в корзину");
        }
    }

    @Override
    public void makeOrder(Long userId) {
        try (Connection connect = connection.getConnection();
             PreparedStatement preparedStatement = connect.prepareStatement("UPDATE project.order SET status = ? where userid = ?")) {
            preparedStatement.setString(1, "COMPLETED");
            preparedStatement.setLong(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при оформлении заказа");
        }
    }

    @Override
    public List<Basket> getBasketsByOrderId(Long orderId) throws SQLException {
        try (Connection connect = connection.getConnection();
             PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM project.basket WHERE orderid = ?");) {
            preparedStatement.setLong(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                List<Basket> baskets = new ArrayList<>();
                while (resultSet.next()) {
                    Basket basket = new Basket();
                    Long id = resultSet.getLong("id");
                    Long orderid = resultSet.getLong("orderid");
                    Long productid = resultSet.getLong("productid");
                    Long count = resultSet.getLong("count");
                    basket.setId(id);
                    basket.setOrderId(orderid);
                    basket.setProductId(productid);
                    basket.setCount(count);
                    baskets.add(basket);
                }
                return baskets;
            }
        }
    }



    @Override
    public void cleanBas(Long orderId, List<Long> productId, List<Long> count) {
        final String tableDeleteBasket = "DELETE FROM project.basket where orderid = ?";
        final String tableDeleteOrders = "DELETE FROM project.order where id = ?";
        final String selectCountProduct = "UPDATE project.product SET quantity = ? where id = ?";
        try (Connection connect = connection.getConnection();
             PreparedStatement preparedStatementStatus = connect.prepareStatement("select status from project.order WHERE id = ?");
             PreparedStatement preparedStatementQuantity = connect.prepareStatement("SELECT quantity from project.product WHERE id = ?");
             PreparedStatement preparedStatementProduct = connect.prepareStatement(selectCountProduct);
             PreparedStatement preparedStatementBasket = connect.prepareStatement(tableDeleteBasket);
             PreparedStatement preparedStatementOrders = connect.prepareStatement(tableDeleteOrders);) {
            preparedStatementStatus.setLong(1, orderId);
            ResultSet status = preparedStatementStatus.executeQuery();
            status.next();
            String statusString = status.getString(1);
            ResultSet resultSet = null;
            for (int i = 0; i < productId.size(); i++) {
                Long product = productId.get(i);
                preparedStatementQuantity.setLong(1, product);
                resultSet = preparedStatementQuantity.executeQuery();
                resultSet.next();
                long quantity = resultSet.getLong("quantity");
                quantity += count.get(i);
                preparedStatementProduct.setLong(1, quantity);
                preparedStatementProduct.setLong(2, product);
                preparedStatementProduct.executeUpdate();
            }
            if (statusString.equals("Создан") && statusString != null) {
                preparedStatementBasket.setLong(1, orderId);
                preparedStatementBasket.executeUpdate();
                preparedStatementOrders.setLong(1, orderId);
                preparedStatementOrders.executeUpdate();
            } else {
                throw new RuntimeException("Корзина пустая, сформируйте заказ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при очистке корзины");
        }
    }

    @Override
    public void clean() {
        try (Connection con = connection.getConnection();
             PreparedStatement preparedStatementBasket = con.prepareStatement("DELETE FROM project.basket");
             PreparedStatement preparedStatementOrders = con.prepareStatement("DELETE FROM project.order WHERE status = 'ORDERING'")) {
            preparedStatementBasket.executeUpdate();
            preparedStatementOrders.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
