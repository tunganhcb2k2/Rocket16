package Exercise2.Q1;

import java.util.Random;

public class Student implements IStudent {
    private int id;
    private String name;
    private int group;
    private Random random;

    public Student(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public Student(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void diemDanh() {
        System.out.println(name + " diem danh");
    }

    @Override
    public void hocBai() {
        System.out.println(name + " dang hoc bai");

    }

    @Override
    public void diDonVeSinh() {
        System.out.println(name + " dang di don ve sinh");
    }
}
