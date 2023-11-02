package com.codegym.huyc08.entity;

public abstract class User {
    protected int userId;
    protected String username;
    protected String password;
    protected double walletBalance;
    protected UserType userType;
    protected boolean isActive;
    public User(int userId, String username, String password, double walletBalance, UserType userType, boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.walletBalance = walletBalance;
        this.userType = userType;
        this.isActive = isActive;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", walletBalance=" + walletBalance +
                ", userType=" + userType +
                ", isActive=" + isActive +
                '}';
    }
}
