package com.vti.frontend;

import com.vti.entity.Account;
import com.vti.entity.Department;

public class Program1 {
    public static void main(String[] args) {
        // Q1:
        Department dep = new Department();
        Department dep1 = new Department(0, "TAH");
        System.out.println(dep);
        System.out.println(dep1);
        //Q2:
        Account acc = new Account();
        Account acc1 = new Account(1, "tah@gmail.com", "TAH", "Hoang Nguyen Tung Anh");
        System.out.println(acc);
        System.out.println(acc1);
    }
}
