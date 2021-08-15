package backend.dataLayer;

import Ultis.JDBCUtils;
import entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public static void getListAccounts() throws SQLException, ClassNotFoundException {
        String sql = "Select `AccountID`,`Username` from `Account` order by `AccountID` asc;";
        Statement statement = JDBCUtils.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Account> accounts = new ArrayList<>();

        while (resultSet.next()) {
            Account acc = new Account(resultSet.getInt("AccountID"), resultSet.getString("Username"));
            accounts.add(acc);
        }
        JDBCUtils.disConnection();
    }
}
