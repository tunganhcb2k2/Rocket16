package exercise;

import Data.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class exercise3 {
    public static void main(String[] args) {
        // tao CategoryQuestion
        CategoryQuestion CQ1 = new CategoryQuestion();
        CQ1.categoryID = 1;
        CQ1.categoryName = "Java";

        CategoryQuestion CQ2 = new CategoryQuestion();
        CQ2.categoryID = 2;
        CQ2.categoryName = ".NET";

        CategoryQuestion CQ3 = new CategoryQuestion();
        CQ3.categoryID = 3;
        CQ3.categoryName = "SQL";

        // tao Department
        Department department1 = new Department();
        department1.departmentID = 1;
        department1.departmentName = "sale";

        Department department2 = new Department();
        department2.departmentID = 2;
        department2.departmentName = "Marketing";

        Department department3 = new Department();
        department3.departmentID = 3;
        department3.departmentName = "Giam Doc";


        // tao Position
        Position position1 = new Position();
        position1.positionID = 1;
        position1.positionName = "DEV";

        Position position2 = new Position();
        position2.positionID = 2;
        position2.positionName = "Test";

        Position position3 = new Position();
        position3.positionID = 3;
        position3.positionName = "Master";

        // tao Group
        Group group1 = new Group();
        group1.groupID = 1;
        group1.groupName = "Testing System";
        group1.createDate = new Date(2021, 7, 10);

        Group group2 = new Group();
        group2.groupID = 2;
        group2.groupName = "Sale";
        group2.createDate = new Date(2021, 7, 5);

        Group group3 = new Group();
        group3.groupID = 3;
        group3.groupName = "Development";
        group3.createDate = new Date(2021, 7, 6);

        // tao TypeQuestion
        TypeQuestion TQ1 = new TypeQuestion();
        TQ1.typeID = 1;
        TQ1.typeName = "Essay";

        TypeQuestion TQ2 = new TypeQuestion();
        TQ2.typeID = 2;
        TQ2.typeName = "Multiple-Choice";

        TypeQuestion TQ3 = new TypeQuestion();
        TQ3.typeID = 3;
        TQ3.typeName = "Essay";

        //tao Account
        Account account1 = new Account();
        account1.accountID = 1;
        account1.email = "vti1@gmail.com";
        account1.userName = "khabanh";
        account1.fullName = "Ngo Ba Kha";
        account1.departmentID = department2;
        account1.positionID = position2;
        account1.createDate = new Date(2021, 6, 30);
        account1.groups = new Group[]{group1, group2, group3};

        Account account2 = new Account();
        account2.accountID = 2;
        account2.email = "vti2@gmail.com";
        account2.userName = "huanrose";
        account2.fullName = "Bui Xuan Huan";
        account2.departmentID = department3;
        account2.positionID = position3;
        account2.createDate = new Date(2021, 4, 21);
        account2.groups = new Group[]{group1, group3};

        Account account3 = new Account();
        account3.accountID = 3;
        account3.email = "vti3@gmail.com";
        account3.userName = "Tienbip";
        account3.fullName = "Hoang Van Tien";
        account3.departmentID = department1;
        account3.positionID = position2;
        account3.createDate = new Date(2021, 5, 20);

        // tao Question
        Question Q1 = new Question();
        Q1.questionID = 1;
        Q1.content = "cau hoi 1";
        Q1.categoryID = CQ3;
        Q1.typeID = TQ2;
        Q1.creatorID = account1;
        Q1.createDate = new Date(2021, 7, 5);

        Question Q2 = new Question();
        Q2.questionID = 2;
        Q2.content = "cau hoi 2";
        Q2.categoryID = CQ2;
        Q2.typeID = TQ1;
        Q2.creatorID = account3;
        Q2.createDate = new Date(2021, 7, 6);

        Question Q3 = new Question();
        Q3.questionID = 3;
        Q3.content = "cau hoi 3";
        Q3.categoryID = CQ1;
        Q3.typeID = TQ3;
        Q3.creatorID = account2;
        Q3.createDate = new Date(2021, 7, 8);


        // tao Exam
        Exam E1 = new Exam();
        E1.examID = 1;
        E1.code = 101;
        E1.title = "de thi .NET";
        E1.categoryID = Q2;
        E1.duration = 120;
        E1.creatorID = account3;
        E1.createDate = new Date(2021, 6, 30);

        Exam E2 = new Exam();
        E2.examID = 2;
        E2.code = 102;
        E2.title = "de thi JAVA";
        E2.categoryID = Q3;
        E2.duration = 60;
        E2.creatorID = account1;
        E2.createDate = new Date(2021, 6, 30);

        Exam E3 = new Exam();
        E3.examID = 3;
        E3.code = 103;
        E3.title = "de thi SQL";
        E3.categoryID = Q1;
        E3.duration = 120;
        E3.creatorID = account1;
        E3.createDate = new Date(2021, 6, 20);

        // Question 1:
        // dinh dang createDate theo format VN:
        Locale locale = new Locale("vi", "VN");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(E1.createDate);
        System.out.println("createDate:" + date);

        // Question 2:
        // dinh dang theo nam - thang- ngay - gio - phut - giay:
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Exam[] examArray = {E1, E2, E3};
        for (Exam exam : examArray) {
            date = simpleDateFormat.format(exam.createDate);
            System.out.println(exam.code + ":" + date);
        }

        // Question 3:
        String pattern1 = "yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern1);
        for (Exam exam : examArray) {
            date = simpleDateFormat.format((exam.createDate));
            System.out.println(exam.code + ":" + date);
        }

        // Question 4:
        String pattern2 = "MM-yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern2);
        for (Exam exam : examArray) {
            date = simpleDateFormat.format(exam.createDate);
            System.out.println(exam.code + ":" + date);


        }

        // Question 5:
        String pattern3 = "dd-MM";
        simpleDateFormat = new SimpleDateFormat(pattern3);
        for (Exam exam : examArray) {
            date = simpleDateFormat.format(exam.createDate);
            System.out.println(exam.code + ":" + date);
        }
    }
}
