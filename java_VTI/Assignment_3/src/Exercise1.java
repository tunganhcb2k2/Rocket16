import java.util.Random;

public class Exercise1 {
    public void Q1(){
        float acc1 = 5240.5f;
        float acc2 = 10970.055f;

        int nacc1 = (int) acc1;
        int nacc2 = (int) acc2;
        System.out.println("luong cua acc1 = " + nacc1 + ", luong cua acc2 = " + nacc2);
    }

    public void Q2() {
        Random rd = new Random();
        int number = rd.nextInt(100000);
        System.out.printf("%05d%n" , number);

    }

    public void Q3(){
        Random rd = new Random();
        int number = rd.nextInt(100000);
        System.out.printf("%05d%n" , number);

        String a = String.valueOf(number);
        System.out.println("2 so cuoi = " + a.substring(3));
    }

}
