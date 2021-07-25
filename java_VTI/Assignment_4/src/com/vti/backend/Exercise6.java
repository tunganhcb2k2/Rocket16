package com.vti.backend;

import com.vti.entity.VietnamesePhone;

import java.util.Scanner;

public class Exercise6 {
    static Scanner sc = new Scanner(System.in);

    public void Q1() {

        VietnamesePhone vnPhone = new VietnamesePhone();
        while (true) {
            System.out.println("lua chon chuc nang ban muon su dung:");
            System.out.println("1. InsertContact");
            System.out.println("2. RemoveContact");
            System.out.println("3. updateContact");
            System.out.println("4. SearchContact");
            System.out.println("5. Thoat khoi chuong trinh");

            int menuChoose = sc.nextInt();
            switch (menuChoose) {
                case 1:
                    System.out.print("Nhap ten Contact: ");
                    String name = sc.next();
                    System.out.print("Nhap vao ten so Phone: ");
                    String phone = sc.next();
                    vnPhone.insertContact(name, phone);
                    break;
                case 2:
                    System.out.print("Nhap vao ten Contact can remove: ");
                    String remove = sc.next();
                    vnPhone.removeContact(remove);
                    break;
                case 3:
                    System.out.print("Nhap ten can update: ");
                    String name1 = sc.next();
                    System.out.println("Nhap ten so Phone can update: ");
                    String phone1 = sc.next();
                    vnPhone.updateContact(name1, phone1);
                    System.out.println("ket qua: ");
                    vnPhone.searchContact(name1);
                    break;
                case 4:
                    System.out.print("Nhap ten Contact can search: ");
                    String search = sc.next();
                    vnPhone.searchContact(search);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("ban da nhap sai cu phap, moi ban nhap lai!!!");
                    break;
            }
        }
    }
}
