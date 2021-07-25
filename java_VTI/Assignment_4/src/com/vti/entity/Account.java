package com.vti.entity;

import java.time.LocalDate;
import java.util.Date;

public class Account {
    private int accountID;
    private String email;
    private String userName;
    private String fullName;
    private Department departmentID;
    private Position position;
    private LocalDate createDate;
    private Group[] groups;


    public Account() {
    }

    public Account(int accountID, String email, String userName, String fullName) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
    }

    public Account(int accountID, String email, String userName, String fullName, Position position, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    public Account(int accountID, String email, String userName, String fullName, Position position, LocalDate createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.createDate = createDate;
    }

    public Account(String userName) {
        this.userName = userName;
    }

        public int getAccountID() {
            return accountID;
        }

        public void setAccountID(int accountID) {
            this.accountID = accountID;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Department getDepartmentID() {
            return departmentID;
        }

        public void setDepartmentID(Department departmentID) {
            this.departmentID = departmentID;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public LocalDate getCreateDate() {
            return createDate;
        }

        public void setCreateDate(LocalDate createDate) {
            this.createDate = createDate;
        }

        public Group[] getGroups() {
            return groups;
        }

        //get account ID
    public int getID() {

        return accountID;
    }

    public int creatorID(){
        return accountID;
    }

}

