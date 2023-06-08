package net.app.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private String jdbcURL = "jdbc:mysql://localhost:3306/e_commerce?user=root&serverTimezone=Europe/Istanbul";
    private String jdbcUsername = "root";
    private String jdbcPassword = "HKhk61+-";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
