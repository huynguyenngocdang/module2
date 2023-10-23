package com.codegym.huyc08.entity;

import com.codegym.huyc08.constants.Constants;

public class UserFactory {
    public User createUser(int userId, String username, String password, double walletBalance, UserType userType, boolean isActive) {
        switch (userType) {
            case ADMIN:
                return new User(userId, username, password, walletBalance, Constants.USER_ROLE_ADMIN, isActive);
            case NORMAL:
                return new User(userId, username, password, walletBalance, Constants.USER_ROLE_NORMAL, isActive);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}
