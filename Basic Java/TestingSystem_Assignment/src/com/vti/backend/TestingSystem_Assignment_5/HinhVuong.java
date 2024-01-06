package com.vti.backend.TestingSystem_Assignment_5;

public class HinhVuong extends HinhChuNhat {
    @Override
    public void tinhChuVi() {
        System.out.println("Tinh chu vi hình vuong");
        System.out.println("Chu vi hcn: ");
    }
    @Override
    public void tinhDienTich() {
        HinhChuNhat hcn = new HinhChuNhat();
        hcn.tinhDienTich();
    }
}
