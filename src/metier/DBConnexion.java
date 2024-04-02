package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnexion {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/TOUR";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private DBConnexion() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the database driver
                Class.forName("com.mysql.jdbc.Driver");
                // Establish the database connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error connecting to the database..");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
