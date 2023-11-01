package com.codegym.huyc08.service;

public class LoginLogger extends Handler {


    public LoginLogger(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {

        UserListManagement.setCurrentUser(request.getUsername(), request.getPassword());
        System.out.println("Set current user with username, password successful");
        return false;
    }

}
