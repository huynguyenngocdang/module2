package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ValidatorUserExist implements Validator{
    private String name;
    private List<NormalUser> users;

    public ValidatorUserExist(String name) {
        this.name = name;
        this.users =  UserManagement.getNormalUsers();
    }

    @Override
    public boolean isCheck() {
        for (User user: users
             ) {
            if(user.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
