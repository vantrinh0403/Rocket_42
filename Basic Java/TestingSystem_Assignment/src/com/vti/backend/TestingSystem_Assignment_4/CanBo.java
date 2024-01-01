package com.vti.backend.TestingSystem_Assignment_4;

public class CanBo {
    private long id;
    private String fullName;
    private int age;
    private Gender gender;
    private String address;

    public CanBo() {}

    public CanBo(long id, String fullName, int age, Gender gender, String address) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
@Override
    public String toString() {
        return "\nCán bộ:" + "\nTên: " + fullName + "\nTuổi: " + age + "\nGiới tính: " + gender + "\nĐịa chỉ: " + address;
    }
}
