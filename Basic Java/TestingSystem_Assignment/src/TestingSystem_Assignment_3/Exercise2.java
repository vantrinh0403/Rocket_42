package TestingSystem_Assignment_3;

import TestingSystem_Assignment_1.Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exercise2 {
    public static void Question1(){
        List<Account> accounts = new ArrayList<>();
        for(int i = 1;i <= 5; i++){
            Account account = new Account();
            account.email = "Email " + i;
            account.userName = "User name " + i;
            account.fullName = "Full name " + i;
            account.createDate = new Date();
            accounts.add(account);
        }
        for(Account account: accounts) {
            System.out.println(account);  //method toString() class Account
        }
    }
}
