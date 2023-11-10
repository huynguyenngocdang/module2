package com.codegym.huyc08.entity;

public class Admin extends User{


    public Admin(int userId, String username, String password, double walletBalance, UserType userType, String address, boolean isActive) {
        super(userId, username, password, walletBalance, userType, address, isActive);
    }
}
