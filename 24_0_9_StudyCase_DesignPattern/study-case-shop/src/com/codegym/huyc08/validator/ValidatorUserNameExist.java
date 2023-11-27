package com.codegym.huyc08.validator;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.service.SingletonListNormalUser;

import java.util.List;

public class ValidatorUserNameExist implements Validator{
    private String username;
    private List<NormalUser> users;

    public ValidatorUserNameExist(String username) {
        this.username = username;
        this.users = SingletonListNormalUser.getInstance().getUsers();
    }
    @Override
    public boolean isCheck() {
        for (User user: users
             ) {
            if( user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
