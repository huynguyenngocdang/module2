package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorUserExist implements Validator{
    private List<NormalUser> users;
    private String username;


    public ValidatorUserExist(String username) {
        this.username = username;
        users = ListManagementUser.getUserList();
    }
    @Override
    public boolean isCheck() {
            for (User user : users
            ) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
            return false;
        }

}
