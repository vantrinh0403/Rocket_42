package com.vti.backend.TestingSystem_Assignment_3;

import com.vti.entity.Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exercise2 {
    public static void Question1(){
        List<Account> accounts = new ArrayList<>();
        for(int i = 1;i <= 5; i++){
            Account account = new Account();
            account.setEmail("Email " + i);
            account.setUserName("User name " + i);
            account.setFullName("Full name " + i);
            account.setCreateDate(new Date());
            accounts.add(account);
        }
        for(Account account: accounts) {
            System.out.println(account);  //method toString() class Account
        }
    }
}
