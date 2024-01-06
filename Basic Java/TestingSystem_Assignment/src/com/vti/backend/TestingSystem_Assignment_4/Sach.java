package com.vti.backend.TestingSystem_Assignment_4;

public class Sach extends TaiLieu {
    private String TenTG;
    private int SoTrang;

    public Sach() {
    }

    public Sach(String maTL, String tenNXB, int soBanPH, TypeTL typeTL, String tenTG, int soTrang) {
        super(maTL, tenNXB, soBanPH, typeTL);
        TenTG = tenTG;
        SoTrang = soTrang;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String tenTG) {
        TenTG = tenTG;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int soTrang) {
        SoTrang = soTrang;
    }
}
