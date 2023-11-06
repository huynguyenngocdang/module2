package com.codegym.huyc08.entity;

public class UserFactory {
    public User createUser(int userId, String username, String password, double walletBalance, UserType userType, boolean isActive) {
        switch (userType) {
            case ADMIN:
                return new Admin(userId, username, password, walletBalance, userType, isActive);
            case NORMAL:
                return new NormalUser(userId, username, password, walletBalance, userType, isActive);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}