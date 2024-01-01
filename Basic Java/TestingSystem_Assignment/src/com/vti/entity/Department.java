package com.vti.entity;

public class Department {
    private long id;
    private String departmentName;

    public Department(){

    }

    public Department(String nameDepartment) {
        this.id = 0;
        this.departmentName = nameDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String toString() {
        return "Id: " + id + ", Department name: " + departmentName;
    }

}
