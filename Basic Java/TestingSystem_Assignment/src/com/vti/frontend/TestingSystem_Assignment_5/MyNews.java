package com.vti.frontend.TestingSystem_Assignment_5;

import com.vti.backend.TestingSystem_Assignment_5.News;

import java.util.Scanner;

public class MyNews {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        News news = new News();

        while (true) {
            System.out.println("===Menu===");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.println("Enter menu:");
            int chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                case 1:
                    System.out.println("Moi ban nhap title: ");
                    news.setTitle(scanner.nextLine());
                    System.out.println("Moi ban nhap PublishDate: ");
                    news.setPublishDate(scanner.nextLine());
                    System.out.println("Moi ban nhap Author: ");
                    news.setAuthor(scanner.nextLine());
                    System.out.println("Moi ban nhap content: ");
                    news.setContent(scanner.nextLine());

                    System.out.println("Moi ban nhap danh gia 1:");
                    news.rates[0] = scanner.nextInt();
                    System.out.println("Moi ban nhap danh gia 2:");
                    news.rates[1] = scanner.nextInt();
                    System.out.println("Moi ban nhap danh gia 3:");
                    news.rates[2] = scanner.nextInt();
                    break;
                case 2:
                    news.Dispaly();
                    break;
                case 3:
                    news.Calculate();
                    news.Dispaly();
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Wrong input, please re-enter.");
                    break;
            }
        }
    }

}
