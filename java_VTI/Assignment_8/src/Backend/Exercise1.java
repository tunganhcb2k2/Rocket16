package Backend;

import Entity.Ex1.Student;

import java.util.*;

public class Exercise1 {
    ArrayList<Student> listStudent = new ArrayList<>();

//    public Exercise1() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap so sinh vien muon them: ");
//        int num = sc.nextInt();
//        for (int i = 0; i < (num - 3); i++) {
//            Student st = new Student("Student" + (i + 1));
//            listStudent.add(st);
//        }
//
//        Student st1 = new Student("StudentName");
//        Student st2 = new Student("StudentName");
//        Student st3 = new Student("StudentName");
//        listStudent.add(st1);
//        listStudent.add(st2);
//        listStudent.add(st3);
//    }

    public void q1() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Moi ban chon chuc nang:");
            System.out.println("1. In ra tong so phan tu cua listStudent.");
            System.out.println("2. Lay phan tu thu 4 cua ListStudent.");
            System.out.println("3. In ra phan tu dau va phan tu cuoi cua listStudent.");
            System.out.println("4. Them 1 phan tu vao vi tri dau cua listStudent.");
            System.out.println("5. Them 1 phan tu vao vi tri cuoi cua listStudent.");
            System.out.println("6. Dao nguoc vi tri cua listStudent.");
            System.out.println("7. Tim kiem Student theo id.");
            System.out.println("8.Tim kiem Student theo name.");
            System.out.println("9. In ra cac student co trung ten.");
            System.out.println("10. Xoa name cua Student co id = 2.");
            System.out.println("11. Delete student co id = 5.");
            System.out.println("12. Tao 1 ArrayList ten la 'studentCopies' va add tat ca student vao.");
            System.out.println("13. Exit");
            System.out.println("----------------------------------------------------");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Tong so phan tu cua listStudent la: " + listStudent.size());
                    break;
                case 2:
                    System.out.println("Phan tu thu 4 cua listStudent la: " + listStudent.get(3));
                    break;
                case 3:
                    System.out.println("Phan tu dau cua listStudent la: " + listStudent.get(0));
                    System.out.println("Phan tu cuoi cua listStudent la: " + listStudent.get(listStudent.size() - 1));
                    break;
                case 4:
                    System.out.print("Nhap ten cua sinh vien can them: ");
                    String name = sc.next();
                    listStudent.add(0, new Student(name));
                    System.out.println("add Student successfully!");
                    break;
                case 5:
                    System.out.print("Nhap ten cua sinh vien can them: ");
                    String name1 = sc.next();
                    listStudent.add(listStudent.size() - 1, new Student(name1));
                    System.out.println("add Student successfully!");
                    break;
                case 6:
                    Collections.reverse(listStudent);
                    System.out.println("Da dao nguoc vi tri");
                    for (int i = 0; i < listStudent.size(); i++) {
                        System.out.println("vi tri " + (i + 1) + ": " + listStudent.get(i));
                    }
                    break;
                case 7:
                    System.out.print("Moi ban nhap vao id = ");
                    int id = sc.nextInt();
                    for (Student student : listStudent) {
                        if (student.getId() == id) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 8:
                    System.out.print("Moi ban nhap vao name = ");
                    String name2 = sc.next();
                    for (Student student : listStudent) {
                        if (student.getName().equals(name2)) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 9:
                    for (int i = 0; i < listStudent.size(); i++) {
                        for (int j = 0; j < listStudent.size(); j++) {
                            if (listStudent.get(i).getName().equals(listStudent.get(j).getName())) {
                                System.out.println(listStudent.get(i));
                            }
                        }
                        break;
                    }
                case 10:
                    for (Student student : listStudent) {
                        if (student.getId() == 2) {
                            student.setName(null);
                        }
                    }
                    break;
                case 11:
                    for (Student student : listStudent) {
                        if (student.getId() == 5) {
                            listStudent.remove(4);
                        }
                    }
                case 12:
                    ArrayList<Student> studentCopies = new ArrayList<>();
                    studentCopies.addAll(listStudent);
                    System.out.println("cac phan tu cua studentCopies:");
                    for (Student student : studentCopies) {
                        System.out.println(student);
                    }
                    break;
                case 13:
                    return;
            }
        }
    }

    public void q2() {
        Stack<Student> studentStack = new Stack<>();
        Student st1 = new Student("A");
        Student st2 = new Student("B");
        Student st3 = new Student("C");
        Student st4 = new Student("D");
        studentStack.push(st1);
        studentStack.push(st2);
        studentStack.push(st3);
        studentStack.push(st4);
        System.out.println("cac hoc sinh theo thu tu tu muon den som nhat: ");

        int n = studentStack.size();
        for (int i = 0; i < n; i++) {
            System.out.println(studentStack.pop().toString());
        }
        System.out.println("--------------------------");
        Queue<Student> studentQueue = new LinkedList<>();
        studentQueue.add(st1);
        studentQueue.add(st2);
        studentQueue.add(st3);
        studentQueue.add(st4);
        System.out.println("cac hoc sinh theo thu tu tu som den muon nhat: ");
        int n1 = studentQueue.size();
        for (int i = 0; i < n1; i++) {
            System.out.println(studentQueue.poll());
        }

    }

    public void q6(){
       Map<Integer,String> students = new HashMap<>();
       students.put(1, "A");
       students.put(2, "B");
       students.put(3, "C");

        for (Map.Entry<Integer, String> mapStudent: students.entrySet()) {
            System.out.println("ID: " + mapStudent.getKey());
            System.out.println("Name: " + mapStudent.getValue());
        }
    }
}


