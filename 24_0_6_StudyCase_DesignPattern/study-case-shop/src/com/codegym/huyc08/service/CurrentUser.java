package com.codegym.huyc08.service;

import com.codegym.huyc08.constants.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser implements Observer  {
    private User user;
    private List<Observer> observers;
    private List<NormalUser> users;
    private MyFileHandler fileHandler = new MyFileHandler();
    private final Validator validator = new Validator();

    public CurrentUser(User user, List<NormalUser> users) {
        this.user = user;
        this.users = users;
        this.observers = new ArrayList<>();
    }

    public void setUsername(String newUsername) {
        if (validator.isLikeable(newUsername, Constants.ADMIN_REGEX)) {
            System.out.println("Your username can't start like admin");
        } else if (validator.isUserExist(newUsername)) {
            System.out.println("Username already exists in the database");
        } else if (validator.isLikeable(newUsername, Constants.USER_REGEX)) {
            user.setUsername(newUsername);
            System.out.println("Set new username successful");
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
    @Override
    public void update() {
        // Handle the update of the current user information
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }


}
