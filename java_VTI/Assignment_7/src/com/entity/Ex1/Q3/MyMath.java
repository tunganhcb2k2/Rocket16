package com.entity.Ex1.Q3;

public class MyMath<a, b> {

    public static int max(int a, int b) {
        if (a <= b) {
            return b;
        } else {
            return a;
        }
    }

    public static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

}