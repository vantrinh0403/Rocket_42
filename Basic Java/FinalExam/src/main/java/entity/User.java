package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Role role;

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    public enum Role {
        EMPLOYEE, ADMIN
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
