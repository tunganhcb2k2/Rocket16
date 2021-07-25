import java.time.LocalDate;
import java.util.Date;

public class Group {
    public int groupID;
    public String groupName;
    public Account creatorID;
    public LocalDate createDate;
    public Account[] accounts;
    public String[] userName;

    public Group() {
    }

    public Group(int groupID, String groupName, Account creatorID, LocalDate createDate, Account[] accounts) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.createDate = createDate;
        this.accounts = accounts;
    }

    public Group(int groupID, String groupName, Account creatorID, LocalDate createDate, String[] userName) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.createDate = createDate;
        this.userName = userName;
        Account[] accounts = new Account[userName.length];
        for (int i = 0; i < userName.length; i++) {
            accounts[i] = new Account(userName[i]);
        }
    }


}

