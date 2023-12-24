package TestingSystem_Assignment_3;

import ConnectMysql.MysqlConnection;
import TestingSystem_Assignment_1.Department;

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
                department1.id = rs.getInt("id");
                department1.departmentName = rs.getString("department_name");

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
                department.id = rs.getInt("id");
                department.departmentName = rs.getString("department_name");
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

}
