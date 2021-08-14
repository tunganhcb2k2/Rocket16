package com.entity.EX4;

import java.io.Serializable;

public class Car implements Serializable {
    private final String name;
    private String color;
    private final String brand;

    public Car(String name, String color, String brand) {
        this.name = name;
        this.color = color;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }


}
