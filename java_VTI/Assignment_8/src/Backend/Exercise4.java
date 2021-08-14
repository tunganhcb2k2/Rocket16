package Backend;

import Entity.Ex4.Salary;

import java.util.ArrayList;

public class Exercise4 {
    public void q1() {
        Salary<Float> S1 = new Salary<Float>(1000.2f);
        System.out.println(S1);
    }

    public <T extends Comparable<T>> void q3(T a, T b) {
        if (a.compareTo(b) > 0) {
            System.out.println("Max la: " + a);
        } else {
            System.out.println("Max la: " + b);
        }
    }

    public void q5() {
        ArrayList<Object> listWildCards = new ArrayList<>();
        listWildCards.add("Nguyen Van Nam");
        listWildCards.add("30 tuoi");
        listWildCards.add("Ha dong, Ha noi");

        for (Object obj : listWildCards) {
            System.out.println(obj);
        }

    }

}
