package Backend;

import Entity.Ex3.Student;

public class Exercise3 {
    public void q1_2() {
        Student<Integer> st1 = new Student<Integer>(1, "A");

        Student<Float> st2 = new Student<Float>(2f, "B");

        Student<Double> st3 = new Student<Double>(3.0, "C");

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);

        System.out.println(4);
        System.out.println(4.0f);
    }

    public <T> void print(T a){
        System.out.println(a);
    }
}
