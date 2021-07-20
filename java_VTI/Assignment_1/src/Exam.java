import java.util.Date;

public class Exam {
    int examID;
    int code;
    String title;
    Question categoryID;
    int duration;
    Account creatorID;
    Date createDate;

    public int getID() {

        return examID;
    }
}
