package com.codegym.huy_c08.entity;

public class NormalUser extends User {

    public NormalUser(int userId, String username, String password, double walletBalance, UserType userType, boolean isActive) {
        super(userId, username, password, walletBalance, userType, isActive);
    }

    @Override
    public void changePassword(String newPassword) {
        // Implementation
        setPassword(newPassword);
    }

    @Override
    public void changeUsername(String newUsername) {
        // Implementation
        setUsername(newUsername);
    }

    @Override
    public void rechargeWallet(double amount) {
        // Implementation
        setWalletBalance(amount);
    }
}

