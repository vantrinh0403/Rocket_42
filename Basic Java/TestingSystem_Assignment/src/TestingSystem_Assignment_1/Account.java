package TestingSystem_Assignment_1;

import java.util.Date;

public class Account {
    public long id;
    public String email;
    public String userName;
    public String fullName;
    public Department department;
    public Position position;
    public Date createDate;
    public Gender gender;
    public float salary;
    public Group[] groups;

    public String toString() {
        return "Account: " + email + ", " + userName + ", " + fullName + ", " + createDate;
    }
}
