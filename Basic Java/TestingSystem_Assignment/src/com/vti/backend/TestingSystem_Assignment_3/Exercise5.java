package com.vti.backend.TestingSystem_Assignment_3;

import ConnectMysql.MysqlConnection;
import com.vti.entity.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    public static void Question1(){
        Department department1 = null;
        String sql = "select * from Department limit 0,1;";
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                department1 = new Department();
                department1.setId(rs.getInt("id"));
                department1.setDepartmentName(rs.getString("department_name"));

            }
            System.out.println(department1);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void Question2(){
        Department department1 = null;
        String sql = "select * from Department;";
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<Department> departments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setDepartmentName(rs.getString("department_name"));
                departments.add(department);

            }

            for(Department dept: departments) {
                System.out.println(dept);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //Question 3

    //Question 4
    public static void Question4() {
        Department department4 = null;
        String sql = "select * from Department limit 0,1;";
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                department4 = new Department();
                department4.setId(rs.getInt("id"));
                department4.setDepartmentName(rs.getString("department_name"));

            }
            if (department4.getDepartmentName().equals("Phòng A")) {
                System.out.println("Ten phong ban thu nhat la \"Phong A\"");
            }else {
                System.out.println("Ten phong ban thu nhat la " + department4.getDepartmentName() + " khong phai \"Phong A\"");
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
