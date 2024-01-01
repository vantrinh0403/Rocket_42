package com.vti.entity;

import java.util.Date;

public class Account {
    private long id;
    private String email;
    private String userName;
    private String fullName;
    private Department department;
    private Position position;
    private Date createDate;
    private Gender gender;
    private float salary;
    private Group[] groups;

    public Account() {

    }

    public Account(long id, String userName, String firstName, String lastName, String email) {
        this.id = id;
        this.userName = userName;
        this.fullName = firstName + lastName;
        this.email = email;
    }

    public Account(long id, String userName, String firstName, String lastName, String email, Position position) {
        this.id = id;
        this.userName = userName;
        this.fullName = firstName + lastName;
        this.email = email;
        this.position = position;
        this.createDate = new Date();
    }

    public Account(long id, String email, String userName, String firstName, String lastName, Position position, Date createDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = firstName + lastName;
        this.position = position;
        this.createDate = createDate;
    }

    public Account(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public String showAccount() {
        return "Account: " + email + ", " + userName + ", " + fullName + ", " + createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                '}';
    }


}
