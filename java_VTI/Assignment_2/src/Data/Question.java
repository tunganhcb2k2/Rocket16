package Data;

import java.util.Date;

public class Question {
    public int questionID;
    public String content;
    public CategoryQuestion categoryID;
    public TypeQuestion typeID;
    public Account creatorID;
    public Date createDate;

    //get Question Id
    public int getID() {
        return questionID;
    }
}
