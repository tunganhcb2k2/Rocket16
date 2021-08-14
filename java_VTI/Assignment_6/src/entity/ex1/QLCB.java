package entity.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {

    private List<CanBo> canBos;
    private Scanner scanner;

    public QLCB() {
        canBos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public QLCB(List<CanBo> canBos) {
        this.canBos = canBos;
    }

    public void addCanBo() {
        System.out.print("Bạn muốn add bao nhiêu cán bộ: ");
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            System.out.print("Bạn muốn nhập vào nhân viên(nhập vào 1), Công nhân (nhập vào 2), kỹ sư (nhập vào 3): ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("nhap ho ten: ");
                    String name = scanner.next();
                    System.out.print("nhap tuoi: ");
                    int age = scanner.nextInt();
                    System.out.print("Nhap vao gioi tinh: ===== 1.Male, 2.Female, 3. Unknown==== ");
                    int genNV = scanner.nextInt();
                    GioiTinh gioitinh = null;
                    switch (genNV) {
                        case 1:
                            gioitinh = GioiTinh.NAM;
                            break;
                        case 2:
                            gioitinh = GioiTinh.NU;
                            break;
                        case 3:
                            gioitinh = GioiTinh.KHONGBIET;
                            break;
                        default:
                            System.out.println("ban da nhap sai moi ban nhap lai!!");
                            break;
                    }
                    System.out.print("nhap dia chi: ");
                    String address = scanner.next();
                    System.out.print("nhap cong viec: ");
                    String congViec = scanner.next();
                    NhanVien nhanVien = new NhanVien(name, age, gioitinh, address, congViec);
                    break;
                case 2:
                    System.out.print("nhap ho ten: ");
                    String name1 = scanner.next();
                    System.out.print("nhap tuoi: ");
                    int age1 = scanner.nextInt();
                    System.out.print("nhap gioi tinh: ");
                    int genCN = scanner.nextInt();
                    GioiTinh gioitinh1 = null;
                    switch (genCN) {
                        case 1:
                            gioitinh1 = GioiTinh.NAM;
                            break;
                        case 2:
                            gioitinh1 = GioiTinh.NU;
                            break;
                        case 3:
                            gioitinh1 = GioiTinh.KHONGBIET;
                            break;
                        default:
                            System.out.println("ban da nhap sai moi ban nhap lai!!");
                            break;
                    }
                    System.out.print("nhap dia chi: ");
                    String address1 = scanner.next();
                    System.out.print("nhap bac: ");
                    int bac = scanner.nextInt();

                    CongNhan congNhan = new CongNhan(name1, age1, gioitinh1, address1, bac);
                    break;
                case 3:
                    System.out.print("nhap ho ten: ");
                    String name2 = scanner.next();
                    System.out.print("nhap tuoi: ");
                    int age2 = scanner.nextInt();
                    System.out.print("nhap gioi tinh: ");
                    int genKS = scanner.nextInt();
                    GioiTinh gioitinh2 = null;
                    switch (genKS) {
                        case 1:
                            gioitinh2 = GioiTinh.NAM;
                            break;
                        case 2:
                            gioitinh2 = GioiTinh.NU;
                            break;
                        case 3:
                            gioitinh2 = GioiTinh.KHONGBIET;
                            break;
                        default:
                            System.out.println("ban da nhap sai moi ban nhap lai!!");
                            break;
                    }
                    System.out.print("nhap dia chi: ");
                    String address2 = scanner.next();
                    System.out.print("nhap nganh dao tao: ");
                    String nganh = scanner.next();
                    KySu kySu = new KySu(name2, age2, gioitinh2, address2, nganh);
                    break;

            }
            System.out.println("Nhập thành Cán bộ " + (i + 1));
        }
    }

    public void findByName() {
        // TODO
        System.out.println("findByName");
    }

    public void printListCanBo() {
        for (int i = 0; i < canBos.size(); i++) {
            System.out.println("Thông tin cán bộ " + (i + 1) + " là: ");
        }
        System.out.println("----------------------------");
    }

    public void deleteCanBo(String name) {
        // TODO
        System.out.println("deleteCanBo");
    }

    public void deleteCanBo() {

        String inputName = scanner.nextLine();
        deleteCanBo(inputName);
    }
}
