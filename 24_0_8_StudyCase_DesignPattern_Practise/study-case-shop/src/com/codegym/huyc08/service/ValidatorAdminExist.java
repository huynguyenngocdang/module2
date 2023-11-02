package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorAdminExist implements Validator{
    private List<Admin> admins;
    private String username;

    public ValidatorAdminExist(String username) {
        this.username = username;

        admins = ListManagementAdmin.getUserList();
    }
    @Override
    public boolean isCheck() {
        for (User user : admins
        ) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
