import java.time.LocalDate;

public class Exercise2 {
    public void Q1() {
        Account[] accArray = new Account[5];

        for (int i = 0; i < accArray.length; i++) {
            Account acc = new Account();
            acc.email = "Email " + (i + 1);
            acc.userName = "Username " + (i + 1);
            acc.fullName = "FullName " + (i + 1);
            acc.createDate = LocalDate.now();

            accArray[i] = acc;

            System.out.println("Email: " + accArray[i].email + ", Username " + accArray[i].userName + ", FullName: " + accArray[i].fullName + ", CreateDate: " + accArray[i].createDate);
        }


    }
}
