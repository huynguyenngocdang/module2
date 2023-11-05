package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Admin;

import java.util.List;

public class ValidatorAdminExist implements Validator{
    private List<Admin> admins;
    private String username;

    public ValidatorAdminExist(String username) {
        this.admins = SingletonListAdmin.getInstance().getAdmins();
        this.username = username;
    }

    @Override
    public boolean isCheck() {
        for (Admin admin: admins
             ) {
            if(admin.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
