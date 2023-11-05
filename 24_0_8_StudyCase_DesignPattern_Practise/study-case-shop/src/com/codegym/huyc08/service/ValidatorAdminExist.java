package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorAdminExist implements Validator{
    private String name;
    private List<Admin> admins;

    public ValidatorAdminExist(String name) {
        this.name = name;
        this.admins = UserManagement.getAdmins();
    }

    @Override
    public boolean isCheck() {
        for (User user: admins
        ) {
            if(user.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
