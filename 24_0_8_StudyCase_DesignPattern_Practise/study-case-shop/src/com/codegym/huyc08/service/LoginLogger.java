package com.codegym.huyc08.service;

public class LoginLogger extends Handler {

    public LoginLogger(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        String inputUsername = request.getUsername();
        String inputPassword = request.getPassword();

        Validator validatorUser = new ValidatorUser(inputUsername);
        Validator validatorAdmin = new ValidatorAdmin(inputUsername);

        if (validatorUser.isCheck()) {
            ListManagementUser.setCurrentUser(inputUsername, inputPassword);
            System.out.println("Set current user successful");
            return false;
        } else if (validatorAdmin.isCheck()) {
            ListManagementAdmin.setCurrentAdmin(inputUsername, inputPassword);
            System.out.println("Set current admin successful");
            return false;

        }
        System.out.println("Can't set current user");
        return true;
    }
}
