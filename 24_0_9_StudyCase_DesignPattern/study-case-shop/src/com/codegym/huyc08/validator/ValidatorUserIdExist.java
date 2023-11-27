package com.codegym.huyc08.validator;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.service.SingletonListNormalUser;

import java.util.List;

public class ValidatorUserIdExist implements Validator{
    private int userId;
    private List<NormalUser> users;

    public ValidatorUserIdExist(int userId) {
        this.userId = userId;
        users = SingletonListNormalUser.getInstance().getUsers();
    }

    @Override
    public boolean isCheck() {
        for (User user: users
             ) {
            if (user.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }
}
