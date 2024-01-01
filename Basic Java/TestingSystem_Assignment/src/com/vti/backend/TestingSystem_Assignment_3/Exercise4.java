package com.vti.backend.TestingSystem_Assignment_3;

import java.util.Scanner;

public class Exercise4 {
    public static void Question1() {
        String x = "Nhập một xâu kí tự, đếm số    lượng các từ trong xâu kí tự đó";
        String reg = "(\\s+)";

        String[] arr = x.split(reg);
        int size = arr.length;
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + arr[i]);
        }
    }

    public static void Question2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("String 1: ");
        String s1 = scanner.next();
        System.out.println("String 2: ");
        String s2 = scanner.next();
        String s3 = s1.concat(s2);
        System.out.println(s3);
    }

    public static void Question3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        //ky tu dau cua name
        String firstName = name.substring(0, 1);
        //con lai cua name
        String remainingName = name.substring(1, name.length());
        //in hoa ky tu dau
        firstName = firstName.toUpperCase();
        //noi 2 chuoi
        String new_name = firstName + remainingName;
        System.out.println("Ten dung: " + new_name);
    }

    public static void Question4() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        String[] arr = name.split("");
        int size = name.length();
        for (int i = 0; i < size; i++) {
            System.out.println("Ky tu thu "+ (i+1) + " la: " + arr[i]);
        }
    }
}
