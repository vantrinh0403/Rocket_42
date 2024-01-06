package com.vti.backend.TestingSystem_Assignment_4;

import java.util.Date;

public class Bao extends TaiLieu {
    private Date NgayPH;

    public Bao() {
    }

    public Bao(String maTL, String tenNXB, int soBanPH, TypeTL typeTL, Date ngayPH) {
        super(maTL, tenNXB, soBanPH, typeTL);
        NgayPH = ngayPH;
    }

    public Date getNgayPH() {
        return NgayPH;
    }

    public void setNgayPH(Date ngayPH) {
        NgayPH = ngayPH;
    }
}
