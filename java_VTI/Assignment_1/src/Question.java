import java.util.Date;

public class Question {
    int questionID;
    String content;
    CategoryQuestion categoryID;
    TypeQuestion typeID;
    Account creatorID;
    Date createDate;

    public int getID() {
        return questionID;
    }

}

