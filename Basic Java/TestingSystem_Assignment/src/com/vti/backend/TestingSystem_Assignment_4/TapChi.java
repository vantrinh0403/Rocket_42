package com.vti.backend.TestingSystem_Assignment_4;

import java.util.Date;

public class TapChi extends TaiLieu {
    private String SoPH;
    private Date ThangPH;

    public TapChi() {}

    public TapChi(String maTL, String tenNXB, int soBanPH, TypeTL typeTL, String soPH, Date thangPH) {
        super(maTL, tenNXB, soBanPH, typeTL);
        SoPH = soPH;
        ThangPH = thangPH;
    }

    public String getSoPH() {
        return SoPH;
    }

    public void setSoPH(String soPH) {
        SoPH = soPH;
    }

    public Date getThangPH() {
        return ThangPH;
    }

    public void setThangPH(Date thangPH) {
        ThangPH = thangPH;
    }
}
