package backend;

import entity.main;

import java.sql.CallableStatement;
import java.util.Scanner;

public class Exercise3 {
    public void q1() throws Exception {
        String sql = "call `sp_delete_department`(?);";
        CallableStatement callableStatement = main.getConnection().prepareCall(sql);

        // nhap tu ban phim
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap departmentID can xoa: ");
        int id = sc.nextInt();

        // set parameter
        callableStatement.setInt(1, id);

        // cau lenh
        int effectedRecordAmount = callableStatement.executeUpdate();

        if (effectedRecordAmount == 1) {
            System.out.println("xoa thanh cong!");
        } else {
            throw new Exception("k co ID");
        }
    }
}
