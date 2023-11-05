package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorAdminCorrect implements Validator{
    private String name;
    private String password;
    private List<Admin> admins;

    public ValidatorAdminCorrect(String name, String password ) {
        this.name = name;
        this.password = password;
        this.admins = UserManagement.getAdmins();
    }

    @Override
    public boolean isCheck() {
        for (User user: admins
        ) {
            if(user.getUsername().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
