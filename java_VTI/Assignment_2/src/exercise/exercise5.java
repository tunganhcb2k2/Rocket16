package exercise;

import Data.Account;
import Data.Department;
import Data.Group;
import Data.Position;

import java.util.Date;
import java.util.Scanner;

public class exercise5 {
    public static void main(String[] args) {
        // Question 1:
        Scanner scanner = new Scanner(System.in);
        System.out.print("moi ban nhap so 1:");
        int number1 = scanner.nextInt();
        System.out.print("moi ban nhap so 2:");
        int number2 = scanner.nextInt();
        System.out.print("moi ban nhap so thu 3:");
        int number3 = scanner.nextInt();
        System.out.println("Output:" + number1 + "," + number2 + "," + number3);

        // Question 2:
        System.out.print("moi ban nhap so thuc 1:");
        float N1 = scanner.nextFloat();
        System.out.print("moi ban nhap so thuc 2:");
        float N2 = scanner.nextFloat();
        System.out.println("Output:" + N1 + "," + N2 + ",");

        // Question 3:
        System.out.print("moi ban nhap ho & ten:");
        String name = scanner.nextLine();
        System.out.println("FullName: " + name);

        // Question 4:
        System.out.println("moi ban nhap vao ngay sinh nhat:");
        System.out.print("Day:");
        int Day = scanner.nextInt();
        System.out.print("Month:");
        int Month = scanner.nextInt();
        System.out.print("Year:");
        int Year = scanner.nextInt();
        System.out.println("ngay sinh cua ban la:" + Day + "/" + Month + "/" + Year);


    }

    private static void cau5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("moi ban nhap thong tin account can tao:");
        Account acc = new Account();
        System.out.println("NhapID:");
        acc.accountID = scanner.nextInt();
        System.out.println("Nhap email:");
        acc.email = scanner.next();
        System.out.println("Nhap userName:");
        acc.userName = scanner.next();
        System.out.println("Nhap fullname:");
        acc.fullName = scanner.next();
        System.out.println("nhap positionID:");
        int posNum = scanner.nextInt();
        switch (posNum) {
            case 1:
                Position pos1 = new Position();
                pos1.positionName = "DEV";
                acc.position = pos1;
                break;
            case 2:
                Position pos2 = new Position();
                pos2.positionName = "Test";
                acc.position = pos2;
                break;
            case 3:
                Position pos3 = new Position();
                pos3.positionName = "Master";
                acc.position = pos3;
                break;
            case 4:
                Position pos4 = new Position();
                pos4.positionName = "PM";
                acc.position = pos4;
                break;
        }
        System.out.println("thong tin acc vua nhap la:");
        System.out.println("ID:" + acc.accountID);
        System.out.println("Email:" + acc.email);
        System.out.println("UserName:" + acc.userName);
        System.out.println("FullName:" + acc.fullName);
        System.out.println("Position:" + acc.position.getName());
    }

    private static void cau6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("moi ban nhap vao department");
        Department dep = new Department();
        System.out.print("NhapID:");
        dep.departmentID = scanner.nextInt();
        System.out.print("Nhap Name:");
        dep.departmentName = scanner.next();
        System.out.println("thong tin Department vua nhap la:");
        System.out.println("ID:" + dep.departmentID);
        System.out.println("Name:" + dep.getName());
    }

    private static void cau7() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("moi ban nhap vao 1 so chan:");
        int i = scanner.nextInt();
        if (i % 2 == 0) {
            System.out.println("so ban vua nhap la:" + i);
        } else {
            System.out.println("moi ban nhap lai!!!");
        }

    }

    private static void cau8() {
        System.out.print("moi ban nhap vao chuc nang muon su dung:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                Account acc = new Account();
                System.out.print("accID:");
                acc.accountID = scanner.nextInt();
                System.out.print("userName:");
                acc.userName = scanner.next();
                System.out.print("FullName:");
                acc.fullName = scanner.next();
                System.out.print("Email:");
                acc.email = scanner.next();
                System.out.println("tao thanh cong");
                break;
            case 2:
                Department dep = new Department();
                System.out.print("ID:");
                dep.departmentID = scanner.nextInt();
                System.out.print("Name:");
                dep.departmentName = scanner.next();
                System.out.println("tao thanh cong");
                break;
            default:
                System.out.println("moi ban nhap lai!!!");

        }
    }

    private static void cau9() {
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

        //tao Account
        Account account1 = new Account();
        account1.accountID = 1;
        account1.email = "vti1@gmail.com";
        account1.userName = "khabanh";
        account1.fullName = "Ngo Ba Kha";
        account1.departmentID = department2;
        account1.position = position2;
        account1.createDate = new Date(2021, 6, 30);

        Account account2 = new Account();
        account2.accountID = 2;
        account2.email = "vti2@gmail.com";
        account2.userName = "huanrose";
        account2.fullName = "Bui Xuan Huan";
        account2.departmentID = department3;
        account2.position = position3;
        account2.createDate = new Date(2021, 4, 21);

        Account account3 = new Account();
        account3.accountID = 3;
        account3.email = "vti3@gmail.com";
        account3.userName = "Tienbip";
        account3.fullName = "Hoang Van Tien";
        account3.departmentID = department1;
        account3.position = position2;
        account3.createDate = new Date(2021, 5, 20);


        // tao Group
        Group group1 = new Group();
        group1.groupID = 1;
        group1.groupName = "Testing System";
        group1.creatorID = account2;
        group1.createDate = new Date(2021, 7, 10);

        Group group2 = new Group();
        group2.groupID = 2;
        group2.groupName = "Sale";
        group2.creatorID = account3;
        group2.createDate = new Date(2021, 7, 5);

        Group group3 = new Group();
        group3.groupID = 3;
        group3.groupName = "Development";
        group3.creatorID = account1;
        group3.createDate = new Date(2021, 7, 6);

        Scanner scanner = new Scanner(System.in);
        Account[] accArray = {account1, account2, account3};
        Group[] groupArray = {group1, group2, group3};
        System.out.println("Danh sach cac user trong he thong:");
        for (int i = 0; i < accArray.length; i++) {
            System.out.println(accArray[i].userName);
        }
        System.out.print("Moi ban nhap UserName cua account:");
        String userName = scanner.next();

        System.out.println("Ten cac group:");
        for (int i = 0; i < groupArray.length; i++) {
            System.out.println(groupArray[i].groupName);
        }
        System.out.print("Moi ban nhap ten cua group:");
        String groupName = scanner.next();

        int indexGroup = -1;
        for (int i = 0; i < groupArray.length; i++) {
            if (groupArray[i].groupName.equals(groupName)) {
                indexGroup = i;
            }
        }

        int indexAccount = -1;
        for (int j = 0; j < accArray.length; j++) {
            if (accArray[j].userName.equals(userName)) {
                indexAccount = j;
            }
        }
        if (indexAccount < 0 || indexGroup < 0) {
            System.out.println("Kiem tra lai thong tin ban nhap, khong ton tai account hoac group nay tren he thong!!!");
        } else {
            for (int j = 0; j < accArray.length; j++) {
                if (accArray[j].userName.equals(userName)) {
                    Group[] gradd = {groupArray[indexGroup]};
                    accArray[j].groups = gradd;
                    System.out.println("ban vua Add group: " + accArray[indexAccount].groups[0].groupName + " cho Account: " + accArray[indexAccount].userName);
                }
            }
        }
    }


}





