package by.ankudovich.config;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static final String URL = "jdbc:postgresql://localhost:5432/testteach";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1111";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }
}
