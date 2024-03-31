package by.ankudovich.repository.user;

import by.ankudovich.entity.User;
import by.ankudovich.enums.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import by.ankudovich.config.JDBC;


public class UserRepositoryJDBC implements UserRepository {
    @Override
    public Collection<User> allUsers() {
        Collection<User> allUsers = new ArrayList<>();
        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project.user");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                long id =  resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String login = resultSet.getString(5);
                String roleString = resultSet.getString(4);
                UserRole.Role role = UserRole.Role.valueOf(roleString);
                String password = resultSet.getString(6);
                User user = new User(id, name, surname, login, password, role);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }
   private final String ADD_USER = "INSERT INTO project.user (id, name, surname, login, password, role) VALUES (?, ?, ?, ?, ?, ?)";
    private final String MAX_ID = "select max(id) from project.user";

    @Override
    public User add(User user) {
        try (Connection connection = JDBC.getConnection();
             PreparedStatement countStatement = connection.prepareStatement("SELECT COUNT(*) FROM project.user");
             PreparedStatement preparedStatementMax = connection.prepareStatement(MAX_ID)) {
            ResultSet countResult = countStatement.executeQuery();
            countResult.next();
            int userCount = countResult.getInt(1);
            PreparedStatement preparedStatement;
            if (userCount == 0) {
                preparedStatement = connection.prepareStatement("INSERT INTO project.user (id, \"name\", surname, login, password, role) VALUES (?, ?, ?, ?, ?, ?)");
                user.setRole(UserRole.Role.ADMIN);
            } else {
                preparedStatement = connection.prepareStatement(ADD_USER);
                user.setRole(UserRole.Role.USER);
            }
            ResultSet resultSet = preparedStatementMax.executeQuery();
            resultSet.next();
            long maxId = resultSet.getInt(1);
            preparedStatement.setLong(1, ++maxId);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, String.valueOf(user.getRole()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void deleteUserById(long userId) {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "DELETE FROM project.user WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, userId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to delete user.", ex);
        }
    }

    @Override
    public void updateUser(long id, String newName, String newSurname, String newLogin, String newPassword) {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE user SET name = ?, surname = ?, login = ?, password = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setString(2, newSurname);
            statement.setString(3, newLogin);
            statement.setString(4, newPassword);
            statement.setLong(5, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to update user.", ex);
        }
    }

    @Override
    public User authentication(String login, String password) {
        User user = null;
        try (Connection connection = JDBC.getConnection()) {
            String sql = "SELECT * FROM user WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                UserRole.Role role = UserRole.Role.valueOf(resultSet.getString("role"));
                user = new User(id, name, surname, login, password, role);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to authenticate user.", ex);
        }
        if (user == null) {
            throw new RuntimeException("User not found for provided credentials.");
        }
        return user;
    }

    @Override
    public long userIdGenerator() {
        return 0;
    }

    @Override
    public User getUserById(Long userId) {
        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project.user WHERE id = ?")) {
            preparedStatement.setLong(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String login = resultSet.getString(4);
                    String password = resultSet.getString(5);
                    String roleString = resultSet.getString(6);
                    UserRole.Role role = UserRole.Role.valueOf(roleString);
                    return new User(id, name, surname, login, password, role);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user with ID: " + userId, e);
        }
    }

    @Override
    public User findByLogin(String userLogin) {
        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project.user WHERE login = ?")) {
            preparedStatement.setString(1, userLogin);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String login = resultSet.getString(4);
                    String password = resultSet.getString(5);
                    String roleString = resultSet.getString(6);
                    UserRole.Role role = UserRole.Role.valueOf(roleString);
                    return new User(id, name, surname, login, password, role);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user with login: " + userLogin, e);
        }
    }
}
