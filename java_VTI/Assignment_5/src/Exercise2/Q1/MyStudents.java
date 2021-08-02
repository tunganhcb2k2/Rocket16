package Exercise2.Q1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MyStudents {
    private static ArrayList<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("moi ban chon chuc nang:");
            System.out.println("1. Tao danh sach hoc sinh");
            System.out.println("2. diem danh sinh vien trong lop");
            System.out.println("3. goi nhom 1 di hoc bai");
            System.out.println("4. goi nhom 2 di ve sinh");
            System.out.println("5. Exit");

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            Random random = new Random();
            switch (choose) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        Student st = new Student("Student" + (i + 1), random.nextInt(3) + 1);
                        listStudent.add(st);
                    }
                    break;

                case 2:
                    System.out.println("Ca lop diem danh:");
                    for (Student st : listStudent) {
                        st.diemDanh();
                    }
                    break;

                case 3:
                    System.out.println("Nhom 1 di hoc bai!!!");
                    for (Student st : listStudent) {
                        if (st.getGroup() == 1) {
                            st.hocBai();
                        }

                    }
                    break;

                case 4:
                    System.out.println("Nhom 2 di don ve sinh");
                    for (Student st : listStudent) {
                        if (st.getGroup() == 2) {
                            st.diDonVeSinh();
                        }

                    }

                case 5:
                    return;

                default:
                    System.out.println("Ban da nhap sai cu phap, moi ban nhap lai!!!");
                    break;
            }
        }
    }
}
