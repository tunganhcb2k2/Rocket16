package Exercise2.Q2;

import java.time.LocalDate;
import java.util.Scanner;


public class Person {
    private static String name;
    private static Gender gender;
    private static LocalDate dateOfBirth;
    private static String address;

    public enum Gender {MALE, FEMALE, UNKNOWN}

    public static Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(String name, LocalDate dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
       this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
       this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

//    public static void main(String[] args) {
//        showInfo();
//    }

    public static void inputInfo() {
        System.out.print("Name: ");
        Person.name = sc.next();
        System.out.print("gender [1.MALE, 2.FEMALE, 3. UNKNOWN]: ");
        int gender = sc.nextInt();
        switch (gender) {
            case 1:
                Person.gender = Gender.MALE;
                break;
            case 2:
                Person.gender = Gender.FEMALE;
                break;
            case 3:
                Person.gender = Gender.UNKNOWN;
                break;
            default:
                System.out.println("ban da nhap sai cu phap!");
                break;
        }
        System.out.print("Date of birth: ");
        Person.dateOfBirth = LocalDate.parse(sc.next());
        System.out.print("Address: ");
        Person.address = sc.next();

    }

    public static String showInfo(){
        return "Name: " + name + ", Gender: " + gender + ", DateOfBirth: " + dateOfBirth + ", Address: " + address ;
    }
}
