package com.codegym.huy_c08.entity;

import java.util.List;

public class Admin extends User implements PromotionProgram, AdminPermission {
    // Implement methods from PromotionProgram interface


    public Admin(int userId, String username, String password, double walletBalance, UserType userType, boolean isActive) {
        super(userId, username, password, walletBalance, userType, isActive);
    }

    @Override
    public void createPromotionProgram() {
        // Implementation
    }

    @Override
    public void changeNormalUserPassword(User user, List<User> userList, String newPassword) {
        // Implementation
        if (userList.contains(user)){
            int index = userList.indexOf(user);
            userList.remove(user);
            user.setPassword(newPassword);
            userList.add(index, user);
        }
    }

    @Override
    public void deleteUser(User user, List<User> userList) {
        // Implementation
        userList.remove(user);
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

