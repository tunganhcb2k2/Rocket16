package backend.presentationlayer;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserController {
    public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException;

    public void Login(String email, String password) throws ClassNotFoundException, SQLException;

    public List<User> getListManager() throws ClassNotFoundException, SQLException;

    public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException;
}
