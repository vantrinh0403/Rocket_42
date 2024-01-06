package com.vti.backend.TestingSystem_Assignment_5;

public class HinhChuNhat {
    private float a = 0;
    private float b = 0;
    public void tinhChuVi() {
        float chuVi = (a+b)*2;
        System.out.println("Tinh chu vi hình chu nhat");
        System.out.println("Chu vi hcn: " + chuVi);
    }

    public void tinhDienTich() {
        float dienTich = a*b;
        System.out.println("Tinh dien tich hình chu nhat");
        System.out.println("Dien tich hcn = " + dienTich);
    }
}
