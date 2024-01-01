package com.vti.frontend.testingsystem_assignment_2;

import com.vti.backend.TestingSystem_Assignment_2.Exercise1;
import com.vti.entity.Account;

public class Program {
    public static void main(String[] args) {

        //Exercise 1 - Question 1
        Account account2 = Exercise1.Question_1();
        if (account2 == null){
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account2.getDepartment().getDepartmentName());
        }

        //Exercise 1 - Question 2
        int number = Exercise1.Question_2();
        if (number == 0){
            System.out.println("Nhân viên này chưa có group");
        } else if (number == 1 || number == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        }else if (number == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        }else if (number >= 4) {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }else {
            System.out.println("Error !!!");
        }

        //Exercise 1 - Question 3
        Account account3 = Exercise1.Question_1();
        String mess = (account3 == null) ? ("Nhân viên này chưa có phòng ban") : ("Phòng ban của nhân viên này là " + account3.getDepartment().getDepartmentName());
        System.out.println(mess);

        //Exercise 1 - Question 4
        Account account4 = Exercise1.Question_4();
        String q4 = (account4.getPosition().getPositionName() .equals("Dev") ) ? ("Đây là Developer") : ("Người này không phải là Developer");
        System.out.println(q4);

        //Exercise 1 - Questipn 5
    }
}
