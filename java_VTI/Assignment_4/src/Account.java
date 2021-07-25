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

    public Account() {
    }

    public Account(int accountID, String email, String userName, String fullName) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
    }

    public Account(int accountID, String email, String userName, String fullName, Position position, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    public Account(int accountID, String email, String userName, String fullName, Position position, LocalDate createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.createDate = createDate;
    }

    public Account(String userName) {
        this.userName = userName;
    }

    //get account ID
    public int getID() {

        return accountID;
    }

    public int creatorID(){
        return accountID;
    }

    private void Q2() {
        Account acc = new Account();
        Account acc1 = new Account(1, "tah@gmail.com", "TAH", "Hoang Nguyen Tung Anh");
    }
}

