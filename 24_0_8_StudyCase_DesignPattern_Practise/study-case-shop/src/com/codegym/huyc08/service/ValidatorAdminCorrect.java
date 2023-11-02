package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorAdminCorrect implements Validator{
    private List<Admin> admins;
    private String username;
    private String password;
    public ValidatorAdminCorrect(String username, String password) {
        this.username = username;
        this.password = password;
        admins = ListManagementAdmin.getUserList();
    }
    @Override
    public boolean isCheck() {
        for (User user : admins
        ) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
