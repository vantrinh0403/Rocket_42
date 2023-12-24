package TestingSystem_Assignment_2;

import ConnectMysql.MysqlConnection;
import TestingSystem_Assignment_1.Account;
import TestingSystem_Assignment_1.Department;
import TestingSystem_Assignment_1.Gender;
import TestingSystem_Assignment_1.Position;

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
                account1.id = rs.getInt("id");
                account1.userName = rs.getString("user_name");
                account1.fullName = rs.getString("full_name");
                account1.email = rs.getString("email");
                account1.gender = Gender.valueOf(rs.getString("gender"));
                account1.createDate = rs.getDate("create_date");
                account1.salary = rs.getInt("salary");

                Department department = new Department();
                department.id = rs.getLong("department_id");
                department.departmentName = rs.getString("department_name");
                account1.department = department;

                Position position = new Position();
                position.id = rs.getLong("position_id");
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
        String sql = "select count(*) as number from GroupAccount where account_id =" + account2.id;

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
                account4.id = rs.getInt("id");
                account4.userName = rs.getString("user_name");
                account4.fullName = rs.getString("full_name");
                account4.email = rs.getString("email");
                account4.gender = Gender.valueOf(rs.getString("gender"));
                account4.createDate = rs.getDate("create_date");
                account4.salary = rs.getInt("salary");

                Department department = new Department();
                department.id = rs.getLong("department_id");
                account4.department = department;

                Position position = new Position();
                position.id = rs.getLong("position_id");
                position.positionName = rs.getString("position_name");
                account4.position = position;
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
