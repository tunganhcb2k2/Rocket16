package backend;

import entity.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercise4 {
    public void q1() throws SQLException, ClassNotFoundException {
        try {
            String sql = "delete from `account` where DepartmentID = 3 ;";
            PreparedStatement preparedStatement = main.getConnection().prepareStatement(sql);
            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Delete successfully!");
        } catch (Exception e) {
            main.getConnection().rollback();
            System.out.println("Transaction rollback!");
        }
        String sql = "delete from `Department` where `DepartmentID` = 3;";
        PreparedStatement preparedStatement = main.getConnection().prepareStatement(sql);
        int effectedRecordAmount = preparedStatement.executeUpdate();
        System.out.println("Delete DepartmentID = 3 success!");
    }
}
