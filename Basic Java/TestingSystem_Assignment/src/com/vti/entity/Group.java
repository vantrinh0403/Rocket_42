package com.vti.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group {
    private long id;
    private String groupName;
    private Account account;
    private Date createDate;
    private List<Account> members;

    public Group() {
    }

    public Group(String groupName, Account account, Date createDate, List<Account> members) {
        this.groupName = groupName;
        this.account = account;
        this.createDate = createDate;
        this.members = members;
    }

    public Group(String groupName, Account account, String[] usernames, Date createDate) {
        this.groupName = groupName;
        this.createDate = createDate;
        this.account = account;
        List<Account> accounts = new ArrayList<Account>();
        for (String name : usernames) {
            Account account1 = new Account( name);
            accounts.add(account1);
        }
        this.members = accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                "\ngroupName='" + groupName + '\'' +
                "\naccount=" + account +
                "\ncreateDate=" + createDate +
                "\nmembers=" + members.toString() +
                '}';
    }
}
