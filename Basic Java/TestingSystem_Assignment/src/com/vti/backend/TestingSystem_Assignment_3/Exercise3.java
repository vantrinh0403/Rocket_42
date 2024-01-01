package com.vti.backend.TestingSystem_Assignment_3;

import java.text.DecimalFormat;

public class Exercise3 {

    public static void Question1() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        int salary = 5000;
        float fl = salary;

        System.out.format("%.2f", fl);
    }

    public static void Question2() {
        String str = "1234567";
        Integer number = Integer.valueOf(str);
        System.out.println(number);
        System.out.println(number + " is of type " + number.getClass().getSimpleName());
    }

//    public static void Question3() {
//        Integer so = new Integer("1234567");
//        int number = so;
//        System.out.println(so == number);
//    }

}
