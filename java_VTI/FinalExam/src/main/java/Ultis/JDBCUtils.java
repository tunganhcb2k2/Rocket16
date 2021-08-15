package Ultis;

import java.sql.*;

public class JDBCUtils {
    private static final String URL_DB = "jdbc:mysql://localhost:3306/TestingSystem";
    private static final String USER_DB = "root";
    private static final String PASSWORD = "Bi21022002.";
    private static Connection connection;

    public void connectionTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD);
        System.out.println("connect success!");
    }


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD);
        return connection;
    }


    public void disConnection() throws SQLException {
        connection.close();

    }

    public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
        Connection connnection = getConnection();
        Statement statement = connnection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }

    public PreparedStatement createPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
        Connection connnection = getConnection();
        PreparedStatement preStatement = connnection.prepareStatement(sql);
        return preStatement;
    }

}
