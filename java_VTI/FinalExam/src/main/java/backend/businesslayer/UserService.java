package backend.businesslayer;

import backend.datalayer.UserRepository;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    UserRepository userRepository;
    boolean userManager = false;
    boolean userLogin = false;

    public UserService(){
        userRepository = new UserRepository();
    }

    public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
        return userRepository.isEmailExist(email);
    }


    public void Login(String email, String password) throws ClassNotFoundException, SQLException {
        userManager = false;
        userLogin = false;

        String user = "";
        user = userRepository.Login(email,password);

        if("MANAGER".equals(user)){
            userManager = true;
            System.out.println("Login in succeses user" + user);
            return;
        } else if ("EMPLOYEE".equals(user)){
            userLogin = true;
            System.out.println("Login in succeses user" + user);
            return;
        }
        System.out.println("Login in fail");
    }


    public List<User> getListManager() throws ClassNotFoundException, SQLException {
       return userRepository.getListManager();
    }


    public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException {
      return userRepository.getListUserByID(id);
    }
}
