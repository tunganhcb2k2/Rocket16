package frontend;


import backend.dataLayer.AccountRepository;

import java.sql.SQLException;

public class Program1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountRepository.getListAccounts();
    }
}
