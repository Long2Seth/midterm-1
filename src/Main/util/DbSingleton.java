package Main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    private static String url = "jdbc:postgresql://localhost:5432/midterm";
    private static String username = "postgres";
    private static String password = "2002sep24";
    private static Connection connection;

    private DbSingleton() {
    }

    public static Connection instance() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Error initializing database connection", e);
            }
        }
        return connection;
    }
}
