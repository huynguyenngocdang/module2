package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorUserCorrect implements Validator{
    private String name;
    private String password;
    private List<NormalUser> users;

    public ValidatorUserCorrect(String name, String password ) {
        this.name = name;
        this.password = password;
        this.users = UserManagement.getNormalUsers();
    }

    @Override
    public boolean isCheck() {
        for (User user: users
        ) {
            if(user.getUsername().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
