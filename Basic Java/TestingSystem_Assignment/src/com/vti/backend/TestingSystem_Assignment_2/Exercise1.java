package com.vti.backend.TestingSystem_Assignment_2;

import ConnectMysql.MysqlConnection;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Gender;
import com.vti.entity.Position;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise1 {

    public static Account Question_1() {
        Account account1 = null;
        String sql = "select * from Account inner join Department on Account.department_id = Department.id limit 1,1;";
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                account1 = new Account();
                account1.setId(rs.getInt("id"));
                account1.setUserName(rs.getString("user_name"));
                account1.setFullName(rs.getString("full_name"));
                account1.setEmail(rs.getString("email"));
                account1.setGender(Gender.valueOf(rs.getString("gender")));
                account1.setCreateDate(rs.getDate("create_date"));
                account1.setSalary(rs.getInt("salary"));

                Department department = new Department();
                department.setId(rs.getLong("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                account1.setDepartment(department);

                Position position = new Position();
                position.setId(rs.getLong("position_id"));
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return account1;
    }

    public static int Question_2() {
        Account account2 = Exercise1.Question_1();
        int number = 0;
        String sql = "select count(*) as number from GroupAccount where account_id =" + account2.getId();

        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                number = rs.getInt("number");
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return number;
    }

    public static Account Question_4() {
        Account account4 = null;
        String sql = "select * from Account inner join Position on Account.position_id = Position.id limit 0,1;";
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                account4 = new Account();
                account4.setId(rs.getInt("id"));
                account4.setUserName(rs.getString("user_name"));
                account4.setFullName(rs.getString("full_name"));
                account4.setEmail(rs.getString("email"));
                account4.setGender(Gender.valueOf(rs.getString("gender")));
                account4.setCreateDate(rs.getDate("create_date"));
                account4.setSalary(rs.getInt("salary"));

                Department department = new Department();
                department.setId(rs.getLong("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                account4.setDepartment(department);

                Position position = new Position();
                position.setId(rs.getLong("position_id"));
                position.setPositionName(rs.getString("position_name"));
                account4.setPosition(position);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return account4;
    }
}
