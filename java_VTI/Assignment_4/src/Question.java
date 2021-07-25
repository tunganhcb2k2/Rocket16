import java.util.Date;

public class Question {
    public int questionID;
    public String content;
    public CategoryQuestion categoryID;
    public TypeQuestion typeID;
    public Account creatorID;
    public Date createDate;

    //get Question ID
    public int getID() {
        return questionID;
    }
}
