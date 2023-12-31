package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.List;

public class ValidatorUserCorrect implements Validator{
    private String username;
    private String password;
    private List<NormalUser> users;

    public ValidatorUserCorrect(String username, String password) {
        this.username = username;
        this.password = password;
        this.users = SingletonListNormalUser.getInstance().getUsers();
    }
    @Override
    public boolean isCheck() {
        for (User user: users
        ) {
            if( user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
