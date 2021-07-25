package exercise;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class exercise4 {
    public static void main(String[] args) {
// Question 1:
        Random random = new Random();
        int x = random.nextInt();
        System.out.println(x);

        // Question 2:
        float y = random.nextFloat();
        System.out.println(y);

        // Question 3:
        String[] nameArray = {"A", "B", "C", "D"};
        int i = random.nextInt(nameArray.length);
        System.out.println("ten ngau nhien cua 1 ban trong lop:" + nameArray[i]);

        // Question 4:
        int minDay = (int) LocalDate.of(1995,07,24). toEpochDay();
        int maxDay = (int) LocalDate.of(1995,12,20). toEpochDay();
        long randomInt = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

        // Quesiton 5:
        int now = (int) LocalDate.now().toEpochDay();
        int randomDate = now - random.nextInt(365);
        LocalDate reusultDate = LocalDate.ofEpochDay(randomDate);
        System.out.println("ngay ngau nhien la:" + reusultDate);

        // Question 6:
        int maxDay1 = (int) LocalDate.now().toEpochDay();
        long randomDay1 = random.nextInt(maxDay1);
        LocalDate resultDate = LocalDate.ofEpochDay(randomDay1);
        System.out.println("1 ngay ngau nhien trong qua khu la:" + resultDate);

        // Question 7:
        int z = random.nextInt(999- 100 + 1) + 100; // cong thuc so (max - so min + 1)
        System.out.println(z);
    }
}
