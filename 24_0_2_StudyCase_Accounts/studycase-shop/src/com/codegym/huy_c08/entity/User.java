package com.codegym.huy_c08.entity;

public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String userType;
    private double userCash;
    private boolean isSetPermission = false;
    private boolean isCreateUser = false;
    private boolean isRemoveUser = false;

    public User() {
    }

    public User(int id, String userName, String userPassword, String userType, double userCash, boolean isSetPermission, boolean isCreateUser, boolean isRemoveUser) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userCash = userCash;
        this.isSetPermission = isSetPermission;
        this.isCreateUser = isCreateUser;
        this.isRemoveUser = isRemoveUser;

    }

    public User(int id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = "normal";
        this.userCash = 0;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isSetPermission() {
        return isSetPermission;
    }

    public void setSetPermission(boolean setPermission) {
        isSetPermission = setPermission;
    }

    public boolean isCreateUser() {
        return isCreateUser;
    }

    public void setCreateUser(boolean createUser) {
        isCreateUser = createUser;
    }

    public boolean isRemoveUser() {
        return isRemoveUser;
    }

    public void setRemoveUser(boolean removeUser) {
        isRemoveUser = removeUser;
    }

    public double getUserCash() {
        return userCash;
    }

    public void setUserCash(double userCash) {
        this.userCash = userCash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", userCash=" + userCash +
                ", isSetPermission=" + isSetPermission +
                ", isCreateUser=" + isCreateUser +
                ", isRemoveUser=" + isRemoveUser +
                '}';
    }
}
