package com.vti.backend.TestingSystem_Assignment_4;

import java.util.ArrayList;
import java.util.List;

public class QLCB {
    public static List<CanBo> listCanBo = new ArrayList<>();
    public List<CanBo> addCanBo(CanBo canBo) {
        listCanBo.add(canBo);
        return listCanBo;
    }

    public CanBo findCBbyName(String name) {

        for (CanBo canBo : listCanBo) {
            if (canBo.getFullName().equals(name)) {
                return canBo;
            }
        }
        return null;
    }

    public void delCBbyName(String name) {
        CanBo canBo = findCBbyName(name);
        if (canBo == null) {
            System.out.println("Không có cán bộ nào tên " + name);
        } else {
            listCanBo.remove(canBo);
            System.out.println("Xoá cán bộ " + name + " thành công!!!");
            showListCanBos(listCanBo);
        }
    }

    public void showListCanBos(List<CanBo> canBos) {
        for (CanBo canBo : canBos) {
            System.out.println(canBo);
        }

    }

}
