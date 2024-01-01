package com.vti.backend.TestingSystem_Assignment_4;

public class CongNhan extends CanBo{
    private int level;

    public CongNhan() {
    }

    public CongNhan(long id, String fullName, int age, Gender gender, String address, int level) {
        super(id, fullName, age, gender, address);
        this.level = level;
    }
}
