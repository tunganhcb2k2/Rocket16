package Exercise2.Q3;

import java.util.Scanner;

public class HV implements ICongThuc {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void tinhChuVi() {
        System.out.println("Tinh chu vi theo hinh vuong:");
        System.out.print("Nhap 1 canh cua hinh vuong: ");
        float a = sc.nextFloat();
        System.out.println("Chu vi = " + (4 * a));

    }

    @Override
    public void tinhDienTich() {
        System.out.println("Tinh dien tich theo hinh vuong:");
        System.out.print("Nhap 1 canh cua hinh vuong: ");
        float a = sc.nextFloat();
        System.out.println("Dien tich = " + (a * a));
    }
}
