public class DayTwo {
    public static void main(String[] args){
        AccountDao accountDao = new AccountDao();
        Account account1 = accountDao.getAccount(11);
        if (account1 == null){
            System.out.println("Nguoi nay khong có trong database");
        } else {
            System.out.println(account1.fullName);
        }
    }
}
