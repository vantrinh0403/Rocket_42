package frontend;

import util.JdbcUtil;
import util.ScannerUtil;

import java.sql.SQLException;

public class UserProgram {
    public static void main(String[] args) throws SQLException {
        UserFunction function = new UserFunction();
        while (true) {
            System.out.println("===Menu===");
            System.out.println("1. Xem danh sach User");
            System.out.println("2. Them moi User");
            System.out.println("3. Xoa User by Id");
            System.out.println("4. Exit");
            System.out.println("Enter menu:");
            int chon = ScannerUtil.inputInt();
            switch (chon) {
                case 1:
                    function.findAll();
                    break;
                case 2:
                    function.create();
                    break;
                case 3:
                    function.deleteById();
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Wrong input, please re-enter.");
                    break;
            }
        }
    }
}
