package frontEnd;

import backend.DepartmentDao;

import java.sql.SQLException;

public class Program2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DepartmentDao dep = new DepartmentDao();
        dep.getDepartments();
    }
}
