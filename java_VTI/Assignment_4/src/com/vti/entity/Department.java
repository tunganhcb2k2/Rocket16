package com.vti.entity;

public class Department {
    private int departmentID;
    private String departmentName;
    private String date;

    public Department() {
    }

    public Department(int departmentID, String departmentName) {
        this.departmentID = 0;
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {

        return departmentName;
    }


}
