package com.vti.frontend.testingsystem_assignment_4;

import com.vti.entity.Account;
import com.vti.entity.Group;

import java.util.Date;

public class Program1 {
    public static void main(String[] args) {
//        Department department = new Department();
//        Department department1 = new Department("Sale");
        String[] usernames = {"account1", "account2", "account3"};
        Account account = new Account(1, "creator", "firstName", "lastName", "email@");
        Group group = new Group("Group 1", account, usernames, new Date());

        System.out.println(group);
    }
}
