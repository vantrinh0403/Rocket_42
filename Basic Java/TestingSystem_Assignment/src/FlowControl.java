import java.sql.*;

public class FlowControl {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public FlowControl() {
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

// Exercise 1 (Optional): Flow Control - Question 1
    public Account Question_1(){
        Account account1 = null;
        try {
            rs = stmt.executeQuery("select * from Account inner join Department on Account.department_id = Department.id limit 1,1;" );
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

//Exercise 1 (Optional): Flow Control - Question 2
    public int Question_2(){
        FlowControl flowControl = new FlowControl();
        Account account2 = flowControl.Question_1();
        int number = 0;
        //select count(*) from GroupAccount where account_id = 9;
        try {
            rs = stmt.executeQuery("select count(*) as number from GroupAccount where account_id =" + account2.id );
            while (rs.next()) {

               number = rs.getInt("number");
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return  number;
    }

//Exercise 1 (Optional): Flow Control - Question 3 -> Program.java

//Exercise 1 (Optional): Flow Control - Question 4
    public Account Question_4(){
        Account account4 = null;
        try {
            rs = stmt.executeQuery("select * from Account inner join Position on Account.position_id = Position.id limit 0,1;" );
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
