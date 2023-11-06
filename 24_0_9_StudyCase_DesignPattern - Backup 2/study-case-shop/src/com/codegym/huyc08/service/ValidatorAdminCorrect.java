package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Admin;

import java.util.List;

public class ValidatorAdminCorrect implements Validator{
    private List<Admin> admins;
    private String username;
    private String password;

    public ValidatorAdminCorrect( String username, String password) {
        this.admins = SingletonListAdmin.getInstance().getAdmins();
        this.username = username;
        this.password = password;
    }


    @Override
    public boolean isCheck() {
        for (Admin admin: admins
             ) {
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
