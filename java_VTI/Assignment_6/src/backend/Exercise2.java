package backend;

import entity.ex2.Department;

import java.util.Scanner;

public class Exercise2 {
    public void q1() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so 1: ");
        int num1 = sc.nextInt();
        System.out.print("Nhap vao so 2: ");
        int num2 = sc.nextInt();
        try {
            if (num2 == 0) {
                throw new Exception("co loi khi thuc hien chia cho so 0");
            } else {
                System.out.println("ket qua phep chia 2 so la: " + entity.ex2.Q1.device(num1, num2));
            }
        } catch (Exception e) {
            System.out.println("co loi khi thuc hien chia cho so 0");
        } finally {
            System.out.println("divide completed");
        }
    }

    public void q3() throws Exception {
        int[] number = {1, 2, 3};
        try {
            System.out.println(number[10]);
        } catch (Exception e) {
            throw new Exception("khong tim thay phan tu trong mang!");
        }
    }

    public void q4() throws Exception {
        Department dep1 = new Department("dep1");
        Department dep2 = new Department("dep2");
        Department dep3 = new Department("dep3");
        Department[] deps = {dep1, dep2, dep3};

        Scanner sc = new Scanner(System.in);
        System.out.print("moi nhap vao phan tu thu: ");
        int i = sc.nextInt();
        if (i > deps.length) {
            throw new Exception("cannot find department");
        } else {
            System.out.println(deps[i]);
        }

    }

    public void q5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap vao tuoi: ");
        while (true) {
            try {
                int age = sc.nextInt();
                if (age >= 0) {
                    System.out.println("tuoi cua ban la: " + age);
                    break;
                } else {
                    System.out.println("Wrong inputing! The age must be greater than 0, please input again");
                    System.out.print("Moi ban nhap vao tuoi: ");
                }
            } catch (Exception e) {
//                System.out.println("wrong inputing! Please input an age as int, input again");
//                System.out.println("moi ban nhap vao tuoi: ");
            }
        }

    }
}



