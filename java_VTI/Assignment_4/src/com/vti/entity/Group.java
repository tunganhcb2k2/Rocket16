package com.vti.entity;

import java.time.LocalDate;

public class Group {
    private int groupID;
    private String groupName;
    private Account creatorID;
    private LocalDate createDate;
    private Account[] accounts;
    private String[] userName;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Account creatorID) {
        this.creatorID = creatorID;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public String[] getUserName() {
        return userName;
    }

    public void setUserName(String[] userName) {
        this.userName = userName;
    }
}

   


