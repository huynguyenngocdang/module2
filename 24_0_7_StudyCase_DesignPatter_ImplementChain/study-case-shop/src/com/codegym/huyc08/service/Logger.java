package com.codegym.huyc08.service;

public class Logger extends LoginHandler {


    public Logger(LoginHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {

        UserListManagement.setCurrentUser(request.getUsername(), request.getPassword());
        System.out.println("Set current user with username, password successful");
        return false;
    }

}
