package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    public static final String URL_DB = "jdbc:mysql://localhost:3306/Testing_System_Assignment_2";
    public static final String USER_DB = "root";
    public static final String PASSWORD = "Bi21022002.";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection;
        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD);
        return connection;
    }

}
