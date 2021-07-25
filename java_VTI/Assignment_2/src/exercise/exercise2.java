package exercise;

import Data.Account;
import Data.Department;
import Data.Group;
import Data.Position;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class exercise2 {
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

        // tao account:
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

        // Question 1:
        int i = 5;
        System.out.printf("%d%n", i);

        // Question 2:
        int i1 = 100000000;
        System.out.printf(Locale.US,"%,d%n", i1);

        // Question 3:
        float i2 = (float) 5.567098;
        System.out.printf("%.4f%n", i2);

        // Question 4:
        String s = "Nguyen Van A";
        System.out.printf("Ten toi la " + s + " va toi dang doc than \n" );

        // Question 5:
        String pattern = "dd/mm/yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        // Question 6:
        Account[] accArray = {account1, account2, account3};
        for (Account account : accArray) {
            System.out.printf("%-18s | %-10s| %-10s\n", account.email, account.fullName, account.departmentID.getName());
        }
    }
}
