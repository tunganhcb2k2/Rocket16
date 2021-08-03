package com.entity.Ex1.Q1_Q2;

public class Student {
    private int id;
    private String name;
    public static String college = "Dai hoc bach khoa";
    public static int moneyGroup = 0;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        Student.college = college;
    }

    public String getCollege() {
        return college;
    }


}
