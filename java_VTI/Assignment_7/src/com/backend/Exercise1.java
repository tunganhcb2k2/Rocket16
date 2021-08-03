package com.backend;

import com.entity.Ex1.Q1_Q2.Student;
import com.entity.Ex1.Q3.MyMath;

import java.util.Scanner;

public class Exercise1 {

    public void Q1() {
        Student[] stArray = new Student[3];
        System.out.println("tao 3 Student:");
        Student st1 = new Student("Nguyen Van A");
        Student st2 = new Student("Nguyen Van B");
        Student st3 = new Student("Nguyen Van C");
        stArray = new Student[]{st1, st2, st3};

        Student.college = "Dai hoc cong nghe";

        for (int i = 0; i < stArray.length; i++) {
            System.out.println("id: " + (i + 1) + ", name: " + stArray[i].getName() + ", " + Student.college);
        }

    }

    public void Q2() {
        Student[] stArray = new Student[3];
        System.out.println("tao 3 Student:");
        Student st1 = new Student("Nguyen Van A");
        Student st2 = new Student("Nguyen Van B");
        Student st3 = new Student("Nguyen Van C");
        stArray = new Student[]{st1, st2, st3};

        Student.moneyGroup = 100 * stArray.length;
        System.out.println("Moi nguoi nop quy 100k => Tong quy = " + Student.moneyGroup);
        System.out.println("St1 lay 50k mua bim bim, keo ve lien hoan => quy con lai = " + (Student.moneyGroup -= 50));
        System.out.println("St2 lay 20k di mua banh mi => quy con lai = " + (Student.moneyGroup -= 20));
        System.out.println("St3 lay 150k di mua do dung hoc tap cho nhom => quy con lai = " + (Student.moneyGroup -= 150));
        System.out.println("Ca nhom moi nguoi lai dong quy moi nguoi 50k => quy con lai = " + (Student.moneyGroup += 50 * stArray.length));

    }

    public static void Q3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu 1 = ");
        int a = sc.nextInt();
        System.out.print("Nhap so thu 2 = ");
        int b = sc.nextInt();

        System.out.println("Max a va b la = " + MyMath.max(a, b));
        System.out.println("Min a va b la = " + MyMath.min(a, b));
        System.out.println("Sum a va b la = " + MyMath.sum(a, b));
    }

    public void Q4 (){
        Student st = new Student();
        st.setCollege("DH1");
        System.out.println(st.getCollege());
    }


}


