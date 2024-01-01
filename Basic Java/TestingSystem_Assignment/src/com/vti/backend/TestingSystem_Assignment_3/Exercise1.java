package com.vti.backend.TestingSystem_Assignment_3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise1 {
    public static void Question1(){
        float account1 = 5240.5F;
        float account2 = 10970.055F;

        int int_sala_acc1 = (int) account1;
        int int_sala_acc2 = (int) account2;

        System.out.println("Luong account1 lam tron : " + int_sala_acc1);
        System.out.println("Luong account2 lam tron : " + int_sala_acc2);
    }

    public static String Question2(){
        int value = ThreadLocalRandom.current().nextInt(0, 10000);
        String str = "";
        if (value < 10000) {
            str = String.format("%05d", value);
            return str;
        }
        return str;
    }

    public static void Question3(String number){
        String str = number.substring(3);
        System.out.println("So ngau nhien tu cau 2: " + number);
        System.out.println("2 so cuoi: " + str);

    }

    public static void Question4(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số thứ nhất: ");
        int a = scanner.nextInt();
        System.out.println("Nhập vào số thứ hai: ");
        int b = scanner.nextInt();
        float kq = (float)a/b;
        System.out.println("Ket qua a/b = " + kq);
    }

}
