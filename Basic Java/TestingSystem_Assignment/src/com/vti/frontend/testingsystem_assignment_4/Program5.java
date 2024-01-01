package com.vti.frontend.testingsystem_assignment_4;

import com.vti.backend.TestingSystem_Assignment_4.CanBo;
import com.vti.backend.TestingSystem_Assignment_4.Gender;
import com.vti.backend.TestingSystem_Assignment_4.QLCB;

import static com.vti.backend.TestingSystem_Assignment_4.QLCB.listCanBo;

public class Program5 {
    public static void main(String[] args) {
        //Exercise 5 - Question 2
        CanBo canBo1 = new CanBo(1,"Trinh", 30, Gender.NAM, "Quang Bình");
        CanBo canBo2 = new CanBo(2,"Van", 20, Gender.NAM, "Quang Bình");
        QLCB qlcb = new QLCB();

        //Question 2-a
        qlcb.addCanBo(canBo1);
        qlcb.addCanBo(canBo2);

        //Question 2-b
        if (qlcb.findCBbyName("Trinh") != null) {
            System.out.println(qlcb.findCBbyName("Trinh"));
        } else {
            System.out.println("Không tìm thấy cán bộ nào!!!");
        }
        //Question 2-c
        System.out.println("Danh sách cán bộ:\n");
        qlcb.showListCanBos(listCanBo);

        //Question 2-d
        System.out.println("Danh sách cán bộ sau khi xoá");
        qlcb.delCBbyName("Trinh");

    }
}
