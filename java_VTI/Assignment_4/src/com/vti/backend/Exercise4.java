package com.vti.backend;

import com.vti.entity.Student;

public class Exercise4 {

    public void Q1() {
        Student st1 = new Student("name1", "H1");
        st1.congDiem(5f);
        Student st2 = new Student("name2", "H2");
        st2.congDiem(9f);

        System.out.println("[ten: " + st1.getName() + ", QueQuan: " + st1.getHomeTown() + ", Diem: " + st1.getDiem() + ", XepLoai: " + st1.xepLoai() + "]");
        System.out.println("[ten: " + st2.getName() + ", QueQuan: " + st2.getHomeTown() + ", Diem: " + st2.getDiem() + ", XepLoai: " + st2.xepLoai() + "]");
    }
}



