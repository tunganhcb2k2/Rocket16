package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private float diem;

    public Student() {
    }

    public Student(String name, String homeTown, float diem) {
        this.name = name;
        this.homeTown = homeTown;
        this.diem = 0;
    }

    public Student(String name, String homeTown) {
        this.name = name;
        this.homeTown = homeTown;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

    public void congDiem(Float diemCong) {
        this.diem += diemCong;
    }

      public String xepLoai(){
        String ketQua;
        if(diem <= 4){
            ketQua = "yeu";
        } else if (diem > 4 && diem <= 6){
            ketQua = "Trung Binh";
        }else if (diem >6 && diem <= 8){
            ketQua = "Kha";
        }else{
            ketQua = "Gioi";
        }
        return ketQua;
      }
}


