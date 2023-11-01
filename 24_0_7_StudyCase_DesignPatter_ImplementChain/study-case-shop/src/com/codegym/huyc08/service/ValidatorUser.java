package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUser {
    private final List<NormalUser> users;
    public ValidatorUser() {
        UserListManagement userListManagement = new UserListManagement();
        users = UserListManagement.getUsers();
    }
    public boolean isUserExist(String username, String password) {
        for (User user : users
                ) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLike(String username, String Regex) {
        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

}
