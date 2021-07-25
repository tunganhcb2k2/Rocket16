package com.vti.entity;

public class CanBo {
    protected String name;
    protected int age;
    protected Gender gender;
    protected String address;

    public enum Gender {
        Male, Female, Unknown
    }

    public CanBo() {
    }

    public CanBo(String name, int age, Gender gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {

        return "[Name= " + name + ", Age= " + age + ", Gender= " + gender + ", Address= " + address + "]";
    }
}
