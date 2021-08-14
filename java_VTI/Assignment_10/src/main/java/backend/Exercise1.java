package backend;


import entity.main;

import java.sql.*;
import java.util.Scanner;

public class Exercise1 {
    public void q1() throws SQLException, ClassNotFoundException {
        Connection connection = new main().getConnection();
        System.out.println("Connect success!");
    }

    public void q2() throws SQLException, ClassNotFoundException {
        Connection connection = new main().getConnection();

        Statement statement = connection.createStatement();

        String sql = "select `positionid`,`positionname` from position ORDER BY `positionid` asc;";
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Thong tin Position dang co  tren he thong:");
        String leftAlignFormat = "| %-6d | %-19s |%n";

        System.out.format("+--------+---------------------+%n");
        System.out.format("|   ID   | PositionName        |%n");
        System.out.format("+--------+---------------------+%n");
        while (resultSet.next()) {
            System.out.format(leftAlignFormat, resultSet.getInt("positionid"), resultSet.getString("positionname"));
        }
        System.out.format("+--------+---------------------+%n");
        connection.close();
    }

    public void q3() throws SQLException, ClassNotFoundException {
        System.out.println("Tao position moi:");

        String sql = "Insert into `Position` (PositionID, PositionName)" +
                "Value                  (      ?         , ?      );";
        PreparedStatement preparedStatement = main.getConnection().prepareStatement(sql);

        // Nhap tu ban phim:
        Scanner sc = new Scanner(System.in);
        System.out.print("moi ban nhap PositionID: ");
        int ID = sc.nextInt();
        System.out.print("moi ban nhap PositionName: ");
        String name = sc.next();

        // set parameter
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, name);

        // cau lenh
        int effectedRecordAmount = preparedStatement.executeUpdate();

        //dieu kien
        if (effectedRecordAmount == 1) {
            System.out.println("tao thanh cong");
        } else {
            System.out.println("Da xay ra loi");
        }
    }
}