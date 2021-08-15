package backend.datalayer;

import Ultis.JDBCUtils;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private JDBCUtils jdbc;

    public UserRepository() {
        jdbc = new JDBCUtils();
    }

    public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
        String sql = "Select * from `user` Where `email` = ?";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            jdbc.disConnection();
            return true;
        } else {
            jdbc.disConnection();
            return false;
        }
    }


    public String Login(String email, String password) throws ClassNotFoundException, SQLException {
        String sql = "Select * From `User` Where `email` = ? AND `password` = ? ";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (resultSet.getString("Role").equals("MANAGER")) {
                return "MANAGER";
            } else if (resultSet.getString("Role").equals("EMPLOYEE")) {
                return "EMPLOYEE";
            }
            return null;
        } else {
            return null;
        }
    }


    public List<User> getListManager() throws ClassNotFoundException, SQLException {
        List<User> listUsers = new ArrayList<User>();
        String sql = "Select `UserID`,`email`,`fullname`, `projectID` From `User` Join `ProjectAndUser` on `user`.`id` = `ProjectAndUser`.`UserID` Where `ProjectAndUser`.`Role` = 'MANAGER'";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("UserID"));
            user.setEmail(resultSet.getString("email"));
            user.setFullName(resultSet.getString("fullname"));
            user.setProjectId(resultSet.getInt("projectID"));
            listUsers.add(user);
        }
        return listUsers;
    }


    public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException {
        List<User> listUser = new ArrayList<User>();
        String sql = "Select `UserID`,`email`,`fullname`,`ProjectAndUser`.`Role`,`projectID` From `User` Join `ProjectAndUser` on `user`.`id` = `ProjectAndUser`.`UserID` Where `projectId` = ?";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("UserID"));
            user.setEmail(resultSet.getString("email"));
            user.setFullName(resultSet.getString("fullname"));
            user.setProjectId(resultSet.getInt("projectID"));
            listUser.add(user);
        }
        return listUser;
    }
}
