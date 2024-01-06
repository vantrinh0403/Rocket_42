package com.vti.backend.TestingSystem_Assignment_4;

import java.util.List;

public class QuanLySach {
    public List<TaiLieu> addTaiLieu(List<TaiLieu> taiLieus, TaiLieu taiLieu) {
        taiLieus.add(taiLieu);
        return taiLieus;
    }

    public void delTaiLieu(List<TaiLieu> taiLieus, String maTaiLieu) {
        for (TaiLieu taiLieu : taiLieus) {
            if (taiLieu.getMaTL().equals(maTaiLieu)) {
                taiLieus.remove(taiLieu);
                System.out.println("Xoá tài liệu " + maTaiLieu + " thành công!!!");
                for (TaiLieu taiLieu1 : taiLieus) {
                    System.out.println(taiLieu1);
                }
            } else {
                System.out.println("Không có mã tài liệu: " + maTaiLieu);
            }
        }
    }
}
