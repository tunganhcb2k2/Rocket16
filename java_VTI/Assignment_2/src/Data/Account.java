package Data;

import java.util.Date;

public class Account {
    public int accountID;
    public String email;
    public String userName;
    public String fullName;
    public Department departmentID;
    public Position positionID;
    public Date createDate;
    public Group[] groups;

    //get account Id
    public int getID() {

        return accountID;
    }
}

