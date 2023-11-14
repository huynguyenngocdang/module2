package com.codegym.huyc08.entity;

public class NormalUser extends User{
    public NormalUser(int userId, String username, String password, double walletBalance, UserType userType, String address, boolean isActive) {
        super(userId, username, password, walletBalance, userType, address, isActive);
    }
}
