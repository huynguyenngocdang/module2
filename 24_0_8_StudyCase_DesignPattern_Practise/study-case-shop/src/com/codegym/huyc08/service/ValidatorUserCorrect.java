package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorUserCorrect implements Validator {
    private List<NormalUser> users;
    private String username;
    private String password;

    public ValidatorUserCorrect(String username, String password) {
        this.username = username;
        this.password = password;
        users = ListManagementUser.getUserList();
    }
    @Override
    public boolean isCheck() {
        for (User user : users
        ) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
