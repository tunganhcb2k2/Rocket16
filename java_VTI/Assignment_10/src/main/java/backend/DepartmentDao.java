package backend;

import entity.Department;
import entity.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    public void getDepartments() throws SQLException, ClassNotFoundException {
        String sql = "select `DepartmentID`,`DepartmentName` from `Department` order by `DepartmentID` asc";
        Statement statement = main.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        List<Department> listDep = new ArrayList<Department>();
        while (resultSet.next()) {
            Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
            listDep.add(dep);
        }
        System.out.println("Thong tin cua Department trong he thong la:");
        String leftAlignFormat = "| %-6d | %-19s |%n";

        System.out.format("+--------+---------------------+%n");
        System.out.format("|   ID   | DepartmentName      |%n");
        System.out.format("+--------+---------------------+%n");

        for (Department dep : listDep) {
            System.out.format(leftAlignFormat, dep.getId(), dep.getName());
        }
        System.out.format("+--------+---------------------+%n");
    }


}
