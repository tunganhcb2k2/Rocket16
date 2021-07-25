package exercise;


import Data.*;

import java.util.Date;

public class exercise1 {
    public static void main(String[] args) {
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

        Position position4 = new Position();
        position3.positionID = 4;
        position3.positionName = "PM";

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

        //tao Account
        Account account1 = new Account();
        account1.accountID = 1;
        account1.email = "vti1@gmail.com";
        account1.userName = "khabanh";
        account1.fullName = "Ngo Ba Kha";
        account1.departmentID = department2;
        account1.position = position2;
        account1.createDate = new Date(2021, 6, 30);
        account1.groups = new Group[]{group1, group2, group3};

        Account account2 = new Account();
        account2.accountID = 2;
        account2.email = "vti2@gmail.com";
        account2.userName = "huanrose";
        account2.fullName = "Bui Xuan Huan";
        account2.departmentID = department3;
        account2.position = position3;
        account2.createDate = new Date(2021, 4, 21);
        account2.groups = new Group[]{group1, group3};


        Account account3 = new Account();
        account3.accountID = 3;
        account3.email = "vti3@gmail.com";
        account3.userName = "Tienbip";
        account3.fullName = "Hoang Van Tien";
        account3.departmentID = department1;
        account3.position = position2;
        account3.createDate = new Date(2021, 5, 20);


        // tao GroupAccount
        GroupAccount GA1 = new GroupAccount();
        GA1.groupID = group2;
        GA1.accountID = account3;
        GA1.joinDate = new Date(2021, 7, 6);

        GroupAccount GA2 = new GroupAccount();
        GA2.groupID = group1;
        GA2.accountID = account2;
        GA2.joinDate = new Date(2021, 7, 11);

        GroupAccount GA3 = new GroupAccount();
        GA3.groupID = group3;
        GA3.accountID = account1;
        GA3.joinDate = new Date(2021, 7, 8);


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


        // tao Answer
        Answer A1 = new Answer();
        A1.answerID = 1;
        A1.content = "cau tra loi 1";
        A1.questionID = Q2;
        A1.isCorrect = true;

        Answer A2 = new Answer();
        A2.answerID = 2;
        A2.content = "cau tra loi 2";
        A2.questionID = Q1;
        A2.isCorrect = false;

        Answer A3 = new Answer();
        A3.answerID = 3;
        A3.content = "cau tra loi 3";
        A3.questionID = Q3;
        A3.isCorrect = true;


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
        E3.createDate = new Date(2021, 6, 30);


        // tao ExamQuestion
        ExamQuestion EQ1 = new ExamQuestion();
        EQ1.examID = E3;
        EQ1.questionID = Q1;

        ExamQuestion EQ2 = new ExamQuestion();
        EQ2.examID = E1;
        EQ2.questionID = Q2;

        ExamQuestion EQ3 = new ExamQuestion();
        EQ3.examID = E2;
        EQ3.questionID = Q3;

        // add group Account
        group1.accounts = new Account[]{account1, account2};
        group2.accounts = new Account[]{account2};
        group3.accounts = new Account[]{account1};

        // Question 1:

        if (account2.departmentID != null) {
            System.out.println("phong ban cua nhan vien nay la:" + account2.departmentID.getName());
        } else {
            System.out.println("nhan vien nay chua co phong ban");
        }

        // Question 2:
        if (account2.groups == null) {
            System.out.println("Nhan vien nay chua co group");
        } else if (account2.groups.length == 1 || account2.groups.length == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (account2.groups.length == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 3:
        System.out.println(account2.departmentID != null ? "phong ban cua nhan vien nay la:" + account2.departmentID.getName() : "0 co phong ban");

        // Question 4:
        System.out.println(account1.position.getName() == "DEV" ? "day la Developer" : "nguoi nay khong phai la Developer");

        // Question 5:
        int x = group1.accounts.length;
        switch (x) {
            case 1:
                System.out.println("Nhom co mot thanh vien");
                break;
            case 2:
                System.out.println("Nhom co hai thanh vien");
                break;
            case 3:
                System.out.println("Nhom co ba thanh vien");
                break;
            default:
                System.out.println("Nhom co nhieu thanh vien");
                break;
        }

        // Question 6:
        int y = account2.groups.length;
        switch (y) {
            case 0:
                System.out.println("Nhan vien nay chua co group");
                break;
            case 1, 2:
                System.out.println("Group cua nhan vien nay la Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }

        // Question 7:
        switch (account1.position.getName()) {
            case "DEV":
                System.out.println("Day la Developer");
                break;
            default:
                System.out.println("Nguoi nay khong phai la Developer");
                break;
        }

        // Question 8:
        Account[] accArray = {account1, account2, account3};
        for (Account account : accArray) {
            System.out.println("Email:" + account.email + ",FullName:" + account.fullName + ",DepartmentName:" + account.departmentID.getName());
        }

        // Question 9:
        Department[] depArray = {department1, department2, department3};
        for (Department department : depArray) {
            System.out.println("id:" + department.getID() + ",Name:" + department.getName());
        }

        // Question 10:
        Account[] accArray1 = {account1, account2};
        for (int i = 0; i < accArray1.length; i++) {
            System.out.println("thong tin account thu" + (i + 1) + "la:");
            System.out.println("Email:" + accArray1[i].email);
            System.out.println("FullName:" + accArray1[i].fullName);
            System.out.println("DepartmentName:" + accArray1[i].departmentID.getName());
        }

        // Question 11:
        Department[] departmentArray = {department1, department2};
        for (int i = 0; i < departmentArray.length; i++) {
            System.out.println("thong tin cua department thu " + (i + 1) + "la:");
            System.out.println("ID:" + departmentArray[i].getID());
            System.out.println("Name:" + departmentArray[i].getName());
        }

        // Question 12:
        Department[] depArray1 = {department1, department2, department3};
        for (int i = 0; i < 2; i++) {
            System.out.println("thong tin cua department thu " + (i + 1) + "la:");
            System.out.println("ID:" + depArray1[i].getID());
            System.out.println("Name:" + depArray1[i].getName());
        }

        // Question 13:
        Account[] accArray2 = {account1, account2, account3};
        for (int i = 0; i < accArray2.length; i++) {
            if (i != 1) {
                System.out.println("thong tin cua acc thu " + (i + 1) + " la:");
                System.out.println("Email:" + accArray2[i].email);
                System.out.println("FullName:" + accArray2[i].fullName);
                System.out.println("DepartmentName:" + accArray2[i].departmentID.getName());
            }
        }

        // Question 14:
        for (int i = 0; i < accArray2.length; i++) {
            if (accArray2[i].accountID < 4) {
                System.out.println("thong tin cua acc thu " + (i + 1) + " la:");
                System.out.println("Email:" + accArray2[i].email);
                System.out.println("FullName:" + accArray2[i].fullName);
                System.out.println("DepartmentName:" + accArray2[i].departmentID.getName());
            }
        }

        // Question 15:
        for (int i = 0; i <= 20; i++){
            if(i%2==0){
                System.out.println(i);
            }
        }

        // Question 16:
        int i = 0;
        while (i < accArray1.length){
            System.out.println("thong tin account thu" + (i + 1) + "la:");
            System.out.println("Email:" + accArray1[i].email);
            System.out.println("FullName:" + accArray1[i].fullName);
            System.out.println("DepartmentName:" + accArray1[i].departmentID.getName());
            i++;
        }

        // Question 17:
        int i1 = 0;
        do{
            System.out.println("thong tin account thu" + (i1 + 1) + "la:");
            System.out.println("Email:" + accArray1[i1].email);
            System.out.println("FullName:" + accArray1[i1].fullName);
            System.out.println("DepartmentName:" + accArray1[i1].departmentID.getName());
            i1++;
        } while (i1 < accArray1.length);
    }
}




