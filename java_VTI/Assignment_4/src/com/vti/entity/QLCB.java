package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
    private static ArrayList<CanBo> canBoList;
    private static Scanner sc;

    public QLCB() {
        canBoList = new ArrayList<CanBo>();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        System.out.println("Lua chon chuc nang ban muon su dung:");
        System.out.println("1.Them moi can bo.");
        System.out.println("2.Tim kiem theo ho ten.");
        System.out.println("3.Hien thi thong tin ve danh sach cac can bo.");
        System.out.println("4.Nhap vao ten cua can bo va delete can bo do.");
        System.out.println("5.Thoat khoi chuong trinh");
        System.out.println("");

        int menuChoose = sc.nextInt();
        switch (menuChoose) {
            case 1:
                addCanBo();
                break;
            case 2:
                findByName();
                break;
            case 3:
                printListCanBo();
                break;
            case 4:
                deleteByName();
                break;
            case 5:
                break;
            default:
                System.out.println("ban da nhap sai cu phap, moi ban nhap lai !!!");
                break;
        }

    }

    private static void addCanBo() {
        System.out.println("Lua chon chuc nang ban muon su dung:");
        System.out.println("1. Them KySu");
        System.out.println("2. Them CongNhan");
        System.out.println("3. Them NhanVien");

        int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Nhap vao ten cua KySu: ");
                    String nameKySu = sc.next();
                    System.out.print("nhap vao tuoi cua KySu: ");
                    int ageKySu = sc.nextInt();
                    System.out.println("Nhap vao gioi tinh cua KySu: ===== 1.Male, 2.Female, 3. Unknown==== ");
                    int genKySu = sc.nextInt();
                    CanBo.Gender gender = null;
                    switch (genKySu) {
                        case 1:
                            gender = CanBo.Gender.Male;
                            break;
                        case 2:
                            gender = CanBo.Gender.Female;
                            break;
                        case 3:
                            gender = CanBo.Gender.Unknown;
                            break;
                        default:
                            System.out.println("ban da nhap sai moi ban nhap lai");
                            break;
                    }
                    System.out.print("Nhap dia chi cua KySu: ");
                    String addressKySu = sc.next();
                    System.out.println("Nhap nganh dao tao cua KySu: ");
                    String NDTKySu = sc.next();
                    CanBo KySu = new KySu(nameKySu, ageKySu, gender, addressKySu, NDTKySu);
                    canBoList.add(KySu);
                    break;

                case 2:
                    System.out.print("Nhap vao ten cua CongNhan: ");
                    String nameCongNhan = sc.next();
                    System.out.print("nhap vao tuoi cua CongNhan: ");
                    int ageCongNhan = sc.nextInt();
                    System.out.println("Nhap vao gioi tinh cua CongNhan: ===== 1.Male, 2.Female, 3. Unknown==== ");
                    int genCongNhan = sc.nextInt();
                    CanBo.Gender gender1 = null;
                    switch (genCongNhan) {
                        case 1:
                            gender1 = CanBo.Gender.Male;
                            break;
                        case 2:
                            gender1 = CanBo.Gender.Female;
                            break;
                        case 3:
                            gender1 = CanBo.Gender.Unknown;
                            break;
                        default:
                            System.out.println("ban da nhap sai moi ban nhap lai");
                            break;
                    }
                    System.out.print("Nhap dia chi cua CongNhan: ");
                    String addressCongNhan = sc.next();
                    System.out.print("nhap bac cua CongNhan:");
                    int rankCongNhan = sc.nextInt();
                    CanBo CongNhan = new CongNhan(nameCongNhan, ageCongNhan, gender1, addressCongNhan, rankCongNhan);
                    canBoList.add(CongNhan);
                    break;

                case 3:
                    System.out.print("Nhap vao ten cua NhanVien: ");
                    String nameNhanVien = sc.next();
                    System.out.print("nhap vao tuoi cua NhanVien: ");
                    int ageNhanVien = sc.nextInt();
                    System.out.println("Nhap vao gioi tinh cua NhanVien: ===== 1.Male, 2.Female, 3. Unknown==== ");
                    int genNhanVien = sc.nextInt();
                    CanBo.Gender gender2 = null;
                    switch (genNhanVien) {
                        case 1:
                            gender2 = CanBo.Gender.Male;
                            break;
                        case 2:
                            gender2 = CanBo.Gender.Female;
                            break;
                        case 3:
                            gender2 = CanBo.Gender.Unknown;
                            break;
                        default:
                            System.out.println("ban da nhap sai moi ban nhap lai");
                            break;
                    }
                    System.out.print("Nhap dia chi cua NhanVien: ");
                    String addressNhanVien = sc.next();
                    System.out.print("nhap vao nhiem vu cua NhanVien: ");
                    String nvNv = sc.next();
                    CanBo NhanVien = new NhanVien(nameNhanVien, ageNhanVien, gender2, addressNhanVien, nvNv);
                    canBoList.add(NhanVien);
                    break;
                default:
                    System.out.println("ban da nhap sai cu phap, moi ban nhap lai!!!");
                    break;

            }
        }

        private static void findByName () {
            System.out.print("Moi ban nhap ten muon tim kiem: ");
            String name = sc.next();
            for (CanBo canbo : canBoList) {
                if (canbo.getName().equals(name)) {
                    System.out.println(canbo);
                }

            }
        }

        private static void printListCanBo () {
            for (CanBo canBo : canBoList) {
                System.out.println(canBo);

            }
        }

        private static void deleteByName () {
            System.out.print("Nhap ten can xoa thong tin: ");
            String name = sc.next();
            canBoList.removeIf(canBo -> canBo.getName().equals(name));
            printListCanBo();
        }

    }


