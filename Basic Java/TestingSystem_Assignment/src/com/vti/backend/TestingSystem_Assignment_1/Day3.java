package com.vti.backend.TestingSystem_Assignment_1;

import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class Day3 {
    public static void main(String[] args) {
        //1
        float account1 = 5240.5F;
        float account2 = 10970.055F;

        int int_sala_acc1 = (int) account1;
        int int_sala_acc2 = (int) account2;

//        System.out.println(int_sala_acc1);
//        System.out.println(int_sala_acc2);

        //2
        int value = ThreadLocalRandom.current().nextInt(0, 10000);
        System.out.println(value);
        while (value < 10000) {
            value *= 10;
        }
        System.out.println(value);

        //Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
        //thể cách nhau bằng nhiều khoảng trắng );

        String chuoi = "Nguyen Van    Trinh";

        StringTokenizer stringTokenizer = new StringTokenizer(chuoi);
        int soTuTrongChuoi = stringTokenizer.countTokens();
        System.out.println("Số từ có trong chuỗi \"" + chuoi + "\" = " + soTuTrongChuoi);

        int wordCount = 0;
        String[] strArr = chuoi.split("\\s",0);
        for (String strArr1 : strArr) {
            if (!strArr1.isEmpty())
                wordCount++;
        }

        System.out.println(wordCount);

    }
}
