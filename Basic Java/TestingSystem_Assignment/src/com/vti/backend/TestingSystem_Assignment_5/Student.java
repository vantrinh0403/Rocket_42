package com.vti.backend.TestingSystem_Assignment_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student implements IStudent {
    private int id;
    private String name;
    private  int group;

    public Student() {
    }

    public Student(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public List<Student> students = new ArrayList<>();

    public void insertStudent() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Student student = new Student(i, "Student " + i, random.nextInt(3)+1);

            students.add(student);
        }
        System.out.println("Tạo danh sách sinh viên than công!!!");
    }

    @Override
    public void diemDanh() {
        for (Student student : students) {
            System.out.println(student.getName() + " diem danh");
        }

    }

    @Override
    public void hocBai() {
//        List<Student> studentHB = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup() == 1) {
//                studentHB.add(student);
                System.out.println(student.getName() + " hoc bai");
            }

        }
    }

    @Override
    public void donVeSinh() {
        for (Student student : students) {
            if (student.getGroup() == 2) {
                System.out.println(student.getName() + " di don ve sinh");
            }
        }
    }
}
