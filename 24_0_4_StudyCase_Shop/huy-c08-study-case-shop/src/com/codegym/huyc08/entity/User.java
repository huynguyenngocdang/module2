package com.codegym.huyc08.entity;

public class User {
    private int userId;
    private String username;
    private String userPassword;
    private double userWallet;
    private String userRole;
    private boolean isActive;

    public User() {
    }

    public User(int userId, String username, String userPassword, double userWallet, String userRole, boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.userWallet = userWallet;
        this.userRole = userRole;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(double userWallet) {
        this.userWallet = userWallet;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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
                ", userPassword='" + userPassword + '\'' +
                ", userWallet=" + userWallet +
                ", userRole=" + userRole +
                ", isActive=" + isActive +
                '}';
    }
}
