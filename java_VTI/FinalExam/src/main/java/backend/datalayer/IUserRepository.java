package backend.datalayer;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException;

    public String Login(String email, String password) throws ClassNotFoundException, SQLException;

    public List<User> getListManager() throws ClassNotFoundException, SQLException;

    public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException;
}
