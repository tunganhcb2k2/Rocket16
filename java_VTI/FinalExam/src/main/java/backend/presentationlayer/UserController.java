package backend.presentationlayer;

import backend.businesslayer.UserService;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController implements IUserController {
    UserService userService;

    public UserController(){
        userService = new UserService();
    }

    public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
        return userService.isEmailExist(email);
    }


    public void Login(String email, String password) throws ClassNotFoundException, SQLException {
        userService.Login(email,password);
    }


    public List<User> getListManager() throws ClassNotFoundException, SQLException {
        return userService.getListManager();
    }


    public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException {
        return userService.getListUserByID(id);
    }
}
