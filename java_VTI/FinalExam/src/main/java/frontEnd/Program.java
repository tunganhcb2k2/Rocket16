package frontEnd;


import Ultis.ScannerUltis;

import java.sql.SQLException;

public class Program {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserFunction userFunction = new UserFunction();
        while (true) {
            System.out.println("\t\t --- MENU --- \t\t");
            System.out.println("1. Login ");
            System.out.println("2. getListUserByID ");
            System.out.println("3. getListManager ");
            System.out.println("4. Exit ");
            System.out.print("Moi ban nhap chuc nang:");
            int lc = ScannerUltis.inputInt();
            switch (lc) {
                case 1:
                    userFunction.login();
                    break;
                case 2:
                    userFunction.getListUserByID();
                    break;
                case 3:
                    userFunction.getListManager();
                    break;
                case 4:
                    System.out.println("Thoat thanh cong!");
                    return;
                default:
                    System.err.println("Nhập lại !!!");
                    break;
            }
        }
    }

}
