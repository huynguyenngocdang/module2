package com.codegym.huyc08.service;

public class LoginAuthenticator extends Handler{

    public LoginAuthenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        String inputUsername = request.getUsername();
        String inputPassword = request.getPassword();
        ValidatorUser validatorUser = new ValidatorUser();
        System.out.println("Authenticator!");
        return !validatorUser.isUserExist(inputUsername, inputPassword);
    }
}
