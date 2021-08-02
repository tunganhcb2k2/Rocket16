package Exercise2.Q3;

import java.util.Scanner;

public class HCN implements ICongThuc {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void tinhChuVi() {
        System.out.println("Tinh chu vi theo HCN: ");
        System.out.print("Nhap chieu dai: ");
        float cd = sc.nextFloat();
        System.out.print("Nhap chieu rong: ");
        float cr = sc.nextFloat();
        System.out.println("Chu Vi = " + (cd + cr) * 2);

    }

    @Override
    public void tinhDienTich() {
        System.out.println("Tinh dien tich theo HCN: ");
        System.out.print("Nhap chieu dai: ");
        float cd = sc.nextFloat();
        System.out.print("Nhap chieu rong: ");
        float cr = sc.nextFloat();
        System.out.println("Dien tich = " + (cd * cr));
    }
}

