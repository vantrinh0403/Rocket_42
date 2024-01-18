package repository;

import entity.User;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        try (
                Connection connection = JdbcUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            List<User> users = new ArrayList<>();
            while(rs.next()){
                User user = new User();
                int id = rs.getInt("id");
                user.setId(id);
                String fullName = rs.getString("full_name");
                user.setFullName(fullName);
                String email = rs.getString("email");
                user.setEmail(email);
                String password = rs.getString("password");
                user.setPassword(password);
                String role = rs.getString("role");
                user.setRole(role);

                users.add(user);
            }
            return users;
        }
    }

    public int create(String fullName, String email) throws SQLException {
        String sql = "INSERT INTO users (full_name, email) VALUES (?, ?)";
        try (
             Connection connection = JdbcUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setString(1, fullName);
            pstmt.setString(2, email);
            return pstmt.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setInt(1,id);
            return pstmt.executeUpdate();
        }
    }
}
