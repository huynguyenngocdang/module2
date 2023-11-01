package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class CurrentUser {
    private User user;
    private List<NormalUser> users;
    private MyFileHandler fileHandler = new MyFileHandler();
    private final Validator validator = new Validator();

    public CurrentUser(User user, List<NormalUser> users) {
        this.user = user;
        this.users = users;
    }

    public void setUsername(String newUsername) {
        if (validator.isLikeable(newUsername, Constants.ADMIN_REGEX)) {
            System.out.println("Your username can't start like admin");
        } else if (validator.isUserExist(newUsername)) {
            System.out.println("Username already exists in the database");
        } else if (validator.isLikeable(newUsername, Constants.USER_REGEX)) {
            user.setUsername(newUsername);
            update();
        } else {
            System.out.println("Your username must have at least 3 characters");
        }
    }

    public void setPassword(String newPassword) {
        user.setPassword(newPassword);
        update();
    }
    public void setBalance(int newBalance) {
        user.setWalletBalance(user.getWalletBalance() + newBalance);
        update();
    }

    public void update() {
        // Handle the update of the current user information
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }
}
