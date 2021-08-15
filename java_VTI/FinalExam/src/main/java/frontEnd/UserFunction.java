package frontEnd;

import Ultis.ScannerUltis;
import backend.presentationlayer.UserController;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFunction {
    UserController userController;

    public UserFunction() {
        userController = new UserController();
    }

    public void login() throws SQLException, ClassNotFoundException {
        System.out.println("Nhap Email: ");
        String userName = ScannerUltis.inputEmail();
        System.out.println("Nhap Password: ");
        String passw = ScannerUltis.inputPassword();
        userController.Login(userName, passw);
    }

    public void getListManager() throws SQLException, ClassNotFoundException {
        List<User> uList = new ArrayList<User>();
        uList = userController.getListManager();
        if (uList != null) {
            System.out.printf("%-15s %-25s %-25s %-25s\n", "UserID", "email", "fullname", "projectID");
            for (User user : uList) {
                System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(), user.getProjectId());
            }
        }

    }

    public void getListUserByID() throws SQLException, ClassNotFoundException {
        System.out.println("Moi ban nhap UserID: ");
        int id = ScannerUltis.inputIntPositive();
        List<User> listUser = new ArrayList<User>();
        listUser = userController.getListUserByID(id);
        System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "UserID", "email", "fullname", "Role", "projectID");
        for (User user : listUser) {
            System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(), user.getRole(), user.getProjectId());
        }
    }
}
