package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    public static final String URL_DB = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2";
    public static final String USER_DB = "root";
    public static final String PASSWORD = "Bi21022002.";
    public static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD);
            System.out.println("connect success!");
            return connection;
        } else {
            return null;
        }

    }

    public static void disConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("close success!");
        }

    }
}
