package com.vti.entity;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String name, int age, Gender gender, String address, String congViec) {
        super(name, age, gender, address);
        this.congViec = congViec;
    }

    @Override
    public String toString(){
        return toString() + "[CongViec= " + congViec + "]";
    }
}
