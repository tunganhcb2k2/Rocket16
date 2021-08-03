import java.time.LocalDate;
import java.util.Date;

public class Account {
    public int accountID;
    public String email;
    public String userName;
    public String fullName;
    public Department departmentID;
    public Position position;
    public LocalDate createDate;
    public Group[] groups;

    //get account Id
    public int getID() {

        return accountID;
    }
}

