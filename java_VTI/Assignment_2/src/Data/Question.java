package Data;

import java.util.Date;

public class Question {
    int questionID;
    String content;
    CategoryQuestion categoryID;
    TypeQuestion typeID;
    Account creatorID;
    Date createDate;

    //get Question Id
    public int getID() {
        return questionID;
    }
}
