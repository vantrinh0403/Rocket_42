package TestingSystem_Assignment_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public AccountDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1:3306/TestingSystem_2";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public Account getAccount(long id) {
        Account account = null;
        try {
            rs = stmt.executeQuery("select * from Account where id = " + id);
            while (rs.next()) {
                account = new Account();
                account.id = rs.getInt("id");
                account.userName = rs.getString("user_name");
                account.fullName = rs.getString("full_name");
                account.email = rs.getString("email");
                account.gender = Gender.valueOf(rs.getString("gender"));
                account.createDate = rs.getDate("create_date");
                account.salary = rs.getInt("salary");

                Department department = new Department();
                department.id = rs.getLong("department_id");
                account.department = department;

                Position position = new Position();
                position.id = rs.getLong("position_id");
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return account;
    }

    public Account[] getAllAccount() {
        List<Account> list = new ArrayList<>();
        Account account;
        try {
            rs = stmt.executeQuery("select * from Account");
            while (rs.next()) {
                account = new Account();
                account.id = rs.getInt("id");
                account.userName = rs.getString("user_name");
                account.fullName = rs.getString("full_name");
                account.gender = Gender.valueOf(rs.getString("gender"));
                account.createDate = rs.getDate("create_date");
                account.salary = rs.getInt("salary");

                Department department = new Department();
                department.id = rs.getLong("id");
                account.department = department;
                
                list.add(account);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return list.toArray(new Account[0]);
    }
    
    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
