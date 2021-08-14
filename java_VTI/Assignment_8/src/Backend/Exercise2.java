package Backend;

import Entity.Ex2.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise2 {
    Student st1 = new Student(1, "A", LocalDate.of(2002, 02, 25), 10f);
    Student st2 = new Student(2, "C", LocalDate.of(2001, 03, 05), 8.5f);
    Student st3 = new Student(3, "E", LocalDate.of(2000, 03, 05), 9.5f);
    Student st4 = new Student(4, "F", LocalDate.of(2001, 03, 05), 9f);
    Student st5 = new Student(5, "A", LocalDate.of(2002, 02, 26), 10f);

    public void q1() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        System.out.println("Sap xep theo ten:");
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void q2() {
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(st1);
        listStudent.add(st2);
        listStudent.add(st3);
        listStudent.add(st4);
        listStudent.add(st5);

        System.out.println("sap xep theo name,score,date");
        Collections.sort(listStudent);
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }
}

