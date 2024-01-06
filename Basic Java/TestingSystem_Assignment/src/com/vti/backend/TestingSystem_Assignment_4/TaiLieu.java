package com.vti.backend.TestingSystem_Assignment_4;

public class TaiLieu {
    private String maTL;
    private String tenNXB;
    private int soBanPH;

    private TypeTL typeTL;

    public TaiLieu() {
    }

    public TaiLieu(String maTL, String tenNXB, int soBanPH, TypeTL typeTL) {
        this.maTL = maTL;
        this.tenNXB = tenNXB;
        this.soBanPH = soBanPH;
        this.typeTL = typeTL;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        maTL = maTL;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        tenNXB = tenNXB;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        soBanPH = soBanPH;
    }

    public TypeTL getTypeTL() {
        return typeTL;
    }

    public void setTypeTL(TypeTL typeTL) {
        typeTL = typeTL;
    }

    @Override
    public String toString() {
        return "TaiLieu{" +
                "MaTL='" + maTL + '\'' +
                ", TenNXB='" + tenNXB + '\'' +
                ", SoBanPH=" + soBanPH +
                ", TypeTL=" + typeTL +
                '}';
    }
}
