package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;

public class LoginLogger extends LoginHandler{

    public LoginLogger(LoginHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        Validator validateRegex = new ValidatorRegex(username, Constants.ADMIN_REGEX);
        if(validateRegex.isCheck()) {
            //admin
            UserManagement.setCurrentAdmin(username, password);
            return false;
        } else {
            //user
           UserManagement.setCurrentNormalUser(username, password);
           return false;
        }
    }
}
