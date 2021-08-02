package Exercise1;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews extends News {
    private static ArrayList<News> listNews = new ArrayList<>();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        while (true) {
            System.out.println("Moi ban nhap chuc nang muon su dung: ");
            System.out.println("1. Insert news");
            System.out.println("2. View List News");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Nhap vao Title: ");
                    String title = sc.next();
                    System.out.print("Nhap vao PublishDate: ");
                    String publishDate = sc.next();
                    System.out.print("Nhap vao Author: ");
                    String author = sc.next();
                    System.out.print("Nhap vao Content: ");
                    String content = sc.next();

                    System.out.print("Nhap vao danh gia 1: ");
                    int rate1 = sc.nextInt();
                    System.out.print("Nhap vao danh gia 2: ");
                    int rate2 = sc.nextInt();
                    System.out.print("Nhap vao danh gia 3: ");
                    int rate3 = sc.nextInt();
                    int[] rates = {rate1, rate2, rate3};
                    News news = new News(title, publishDate, author, content, rates);
                    listNews.add(news);
                    break;
                case 2:
                    for (News news1 : listNews) {
                        news1.display();
                    }
                    break;
                case 3:
                    System.out.println("Danh gia trung binh Rate:");
                    for (News news1 : listNews) {
                        news1.Calculate();
                        System.out.println("Title: " + news1.getTitle() + ", AverageRate: " + news1.Calculate());
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("ban da nhap sai cu phap, moi ban nhap lai!!!!");
                    break;
            }

        }
    }

}


