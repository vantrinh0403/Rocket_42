package frontend;

import entity.User;
import repository.UserRepository;
import util.ScannerUtil;

import java.sql.SQLException;
import java.util.List;

public class UserFunction {
    private UserRepository repository = new UserRepository();
    public void findAll() throws SQLException {
        List<User> users = repository.findAll();
        System.out.println("+------+--------------------+--------------------+");
        System.out.println("|  ID  |      FULL NAME     |        EMAIL       |");
        System.out.println("+------+--------------------+--------------------+");
        for (User user : users) {
            int id = user.getId();
            String fullName = user.getFullName();
            String email = user.getEmail();
            System.out.printf("| %-4s | %-18s | %-18s |%n", id, fullName,email);
            System.out.println("+------+--------------------+--------------------+");
        }
    }

    public void create() throws SQLException {
        System.out.println("Moi ban nhap vao thong tin user.");
        System.out.println("Nhap full name: ");
        String fullName = ScannerUtil.inputFullName();
        System.out.println("Nhap email: ");
        String email = ScannerUtil.inputEmail();

        int result = repository.create(fullName, email);
        System.out.printf("Tao thanh cong %d user(s).%n", result);
    }

    public void deleteById() throws SQLException {
        System.out.println("Moi ban nhap id cua user can xoa: ");
        int id = ScannerUtil.inputInt();
        int result = repository.deleteById(id);
        if (result > 0) {
            System.out.printf("Xoa thanh cong %d user(s).%n", result);
        } else {
            System.out.printf("Xoa user %d khong thanh cong.%n", id);
        }
    }
}
