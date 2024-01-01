package com.vti.backend.TestingSystem_Assignment_4;

public class NhanVien extends CanBo{
    private String job;

    public NhanVien(long id, String fullName, int age, Gender gender, String address, String job) {
        super(id, fullName, age, gender, address);
        this.job = job;
    }
}
