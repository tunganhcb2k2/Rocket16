package Data;

import java.util.Date;

public class Account {
    int accountID;
    String email;
    String userName;
    String fullName;
    Department departmentID;
    Position positionID;
    Date createDate;

    //get account Id
    public int getID() {
        return accountID;
    }
}

