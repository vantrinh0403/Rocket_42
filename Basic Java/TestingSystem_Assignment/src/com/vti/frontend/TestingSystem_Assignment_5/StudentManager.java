package com.vti.frontend.TestingSystem_Assignment_5;

import com.vti.backend.TestingSystem_Assignment_5.Student;

import java.util.Scanner;

public class StudentManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Student student = new Student();
        while (true) {
            System.out.println("===Menu===");
            System.out.println("1. Tao 10 hoc sinh thanh 3 nhom");
            System.out.println("2. Diem danh");
            System.out.println("3. Nhom 1 di hoc bai");
            System.out.println("4. Nhom 2 di don ve sinh");
            System.out.println("5. Exit");
            System.out.println("Enter menu:");
            int chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                case 1:
                    student.insertStudent();
                    break;
                case 2:
                    student.diemDanh();
                    break;
                case 3:
                    student.hocBai();
                    break;
                case 4:
                    student.donVeSinh();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Wrong input, please re-enter.");
                    break;
            }
        }

    }
}
