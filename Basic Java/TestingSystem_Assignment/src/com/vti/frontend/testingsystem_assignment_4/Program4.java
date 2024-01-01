package com.vti.frontend.testingsystem_assignment_4;

import com.vti.backend.TestingSystem_Assignment_4.Student;

public class Program4 {
    public static void main(String[] args) {
//        Student student1 = new Student("Trình", "Quảng Bình");
//        student1.setPoint(5);
//        student1.plusPoint(3);
//        System.out.println(student1.showStudent());

        Student student2 = new Student();
        student2.setId(1);
        student2.setName("Trình");
        student2.setHometown("Quảng Bình");
        student2.setPoint(5);

        student2.plusPoint(2);

        System.out.println(student2.showStudent());
    }
}
