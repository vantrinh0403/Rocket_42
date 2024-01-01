package com.vti.backend.TestingSystem_Assignment_4;

public class Student {

    private long id;
    private String name;
    private String hometown;
    private int point;

    public Student() {

    }

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.point = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int plusPoint(int point) {
        this.point = this.point + point;
        return this.point;
    }

    public String showStudent() {
        String stringPoint = "";
        if(point < 4) {
            stringPoint = "Yếu";
        } else if (point >= 4 && point < 6) {
            stringPoint = "Trung bình";
        } else if (point >= 6 && point < 8) {
            stringPoint = "Khá";
        } else if (point >= 8 && point <= 10) {
            stringPoint = "Giỏi";
        } else {
            stringPoint = "Điểm k hợp lệ";
        }
        String result = "Tên: " + name + "\nQuê quán: " + hometown + "\nHọc lực: " + stringPoint;
        return result;
    }
}
