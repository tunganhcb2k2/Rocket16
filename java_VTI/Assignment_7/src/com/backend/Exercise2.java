package com.backend;

import com.entity.Ex2.Q1.MyMath;
import com.entity.Ex2.Q2.Student;

import java.util.Scanner;

public class Exercise2 {

    public void Q1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so a = ");
        float a = sc.nextInt();
        System.out.println("a + pi = " + MyMath.sum(a));

    }

    public final void Q3() {
        Student primaryStudent = new Student(1, "A");
        Student secondaryStudent = new Student(2, "B");
        System.out.println(primaryStudent);
        System.out.println(secondaryStudent);
        System.out.println("primaryStudent" + primaryStudent.study());
        System.out.println("secondaryStudent" + secondaryStudent.study());


    }
}
