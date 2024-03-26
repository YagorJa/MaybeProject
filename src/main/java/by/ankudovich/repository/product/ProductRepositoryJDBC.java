package by.ankudovich.repository.product;

import by.ankudovich.config.JDBC;
import by.ankudovich.entity.Product;
import by.ankudovich.enums.ProductRole;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepositoryJDBC implements ProductRepositoryInter {
    private final String ADD_PRODUCT = "insert into project.product (id, code, \"name\", price, quantity, type_role) " + "values (?,?,?,?,?,?)";
    private final String MAX_ID = "select max(id) from project.product";
    @Override
    public Product add(Product product) {
        try (Connection connection = JDBC.getConnection()) {
            String query = "SELECT id, quantity, code FROM project.product WHERE \"name\" = ? AND type_role = ? AND price = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(query)) {
                checkStatement.setString(1, product.getNameOfProduct());
                checkStatement.setString(2, String.valueOf(product.getTypeOfProduct()));
                checkStatement.setDouble(3, product.getPrice());
                ResultSet resultSet = checkStatement.executeQuery();
                if (resultSet.next()) {
                    long id = resultSet.getLong("id");
//                      long code = resultSet.getLong("code");
                    int existingQuantity = resultSet.getInt("quantity");
                    long newQuantity = existingQuantity + product.getQuantity();
                    updateQuantity(connection, id,  newQuantity);
                } else {
                    insertNewProduct(connection, product);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    private void updateQuantity(Connection connection, long id, long newQuantity) throws SQLException {
        String updateQuery = "UPDATE project.product SET quantity = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setLong(1, newQuantity);
            updateStatement.setLong(2, id);
            updateStatement.executeUpdate();
        }
    }
    private void insertNewProduct(Connection connection, Product product) throws SQLException {
        try (PreparedStatement preparedStatementMax = connection.prepareStatement(MAX_ID)) {
            ResultSet resultSet = preparedStatementMax.executeQuery();
            resultSet.next();
            long maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setLong(1, ++maxId);
            preparedStatement.setLong(2,product.getCodeOfProduct());
            preparedStatement.setString(3, product.getNameOfProduct());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setLong(5, product.getQuantity());
            preparedStatement.setString(6, String.valueOf(product.getTypeOfProduct()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductById(long productId) {
    }

    @Override
    public Collection<Product> allProducts() {
        Collection<Product> products = new ArrayList<>();
        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project.product");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                long id =  resultSet.getLong(1);
                long code = resultSet.getLong(2);
                String name = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                long quantity = resultSet.getLong(5);
                String type_role = resultSet.getString(6);
               ProductRole.PRODUCT role = ProductRole.PRODUCT.valueOf(type_role);
                Product product = new Product(id,code, name, price, quantity, role);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public long productIdGenerator() {
        return 0;
    }

    @Override
    public Product findByName(String productName) {
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project.product WHERE name = ?")) {
            preparedStatement.setString(1, productName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    return new Product(id, Long.valueOf(name), type, price, quantity);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find product with name: " + productName, e);
        }
    }

    @Override
    public Product findById(long productId) {
        return null;
    }
    @Override
    public List<Product> getProductsByIds(List<Long> ids) {
        return null;
    }
}
