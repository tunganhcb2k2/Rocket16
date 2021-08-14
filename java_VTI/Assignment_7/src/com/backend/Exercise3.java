package com.backend;

import ultis.FileManager;

import java.util.Scanner;

public class Exercise3 {
  // LOI~
    public void loadMenuFile() throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Lua chon chuc nang ban muon su dung:");
            System.out.println("1. Check File is exists");
            System.out.println("2. Check Folder");
            System.out.println("3. Create new File");
            System.out.println("4. Delete File");
            System.out.println("5. Get all file of folder");
            System.out.println("6. Coppy File");
            System.out.println("7. Moving File");
            System.out.println("8. Rename File");
            System.out.println("9. Create new folder");
            System.out.println("10. Download File");
            System.out.println("11. Exit");

            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.print("Nhap vao duong dan file can kiem tra: ");
                    String path1 = sc.next();
                    FileManager.isFileExists(path1);
                    break;
                case 2:
                    System.out.print("Nhap vao duong dan can kiem tra xem la file hay folder: ");
                    String path2 = sc.next();
                    FileManager.checkFileOrFolder(path2);
                    break;
                case 3:
                    System.out.print("Nhap vao duong dan va ten de tao file moi: ");
                    String path3 = sc.next();
                    FileManager.createNewFile(path3);
                    break;
                case 4:
                    System.out.print("Nhap vao duong dan de xoa file: ");
                    String path4 = sc.next();
                    FileManager.deleteFile(path4);
                    break;
                case 5:
                    System.out.print("Nhap vao duong dan cua folder: ");
                    String path5 = sc.next();
                    FileManager.getAllFileOfFolder(path5);
                    break;
                case 6:
                    System.out.print("Nhap vao duong dan file goc: ");
                    String path6 = sc.next();
                    System.out.print("Nhap vao duong dan file can copy: ");
                    String path6a = sc.next();
                    FileManager.copyFile(path6, path6a);
                    break;
                case 7:
                    System.out.print("Nhap vao duong dan File can chuyen: ");
                    String path7 = sc.next();
                    System.out.print("Nhap vao duong dan folder: ");
                    String path7a = sc.next();
                    FileManager.movingFile(path7, path7a);
                    break;
                case 8:
                    System.out.print("Nhap vao duong dan file can doi ten: ");
                    String path8 = sc.next();
                    System.out.print("Nhap vao duong dan va ten moi: ");
                    String path8a = sc.next();
                    FileManager.renameFile(path8, path8a);
                    break;
                case 9:
                    System.out.println("Nhap vao duong dan va ten Folder moi");
                    String path9 = sc.next();
                    FileManager.createNewFolder(path9);
                    break;
                case 10:
                    System.out.print("Nhap vao duong dan tai file: ");
                    String path10 = sc.next();
                    System.out.print("Nhap vao duong dan folder luu tru: ");
                    String path10a = sc.next();
                    FileManager.downloadFile(path10, path10a);
                    break;
                case 11:
                    return;
                default:
                    System.out.println("ban da nhap sai cu phap moi ban nhap lai!!!");
                    break;
            }
        }
    }

}



