package com.vti.backend.TestingSystem_Assignment_4;

public class KySu extends CanBo{
    private String industry;

    public KySu(long id, String fullName, int age, Gender gender, String address, String industry) {
        super(id, fullName, age, gender, address);
        this.industry = industry;
    }
}
