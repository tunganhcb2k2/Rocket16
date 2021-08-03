
import java.util.Scanner;

public class Exercise4 {
    public void Q1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap xau ky tu: ");
        String name = sc.nextLine();
        System.out.println("so luong tu trong xau ky tu tren la: " + name.length());


    }

    public void Q3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ten: ");
        String name = sc.nextLine();
        String firstCharacter = name.substring(0, 1).toUpperCase();
        String leftCharacter = name.substring(1);
        name = firstCharacter + leftCharacter;
        System.out.println("ten nhap dung la: " + name);
    }

    public void Q6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho va ten: ");
        String fullName = sc.nextLine();
        String firstName = "", middleName = "", lastName = "";
        // chuan hoa xau
        fullName = fullName.trim();
        String[] words = fullName.split(" ");
        lastName = words[0];
        firstName = words[words.length - 1];
        for (int i = 1; i <= words.length - 2; i++) {
            middleName += words[i] + " ";
        }
        System.out.println("Ho la: " + lastName);
        System.out.println("ten dem la: " + middleName);
        System.out.println("ten la: " + firstName);
    }
}
