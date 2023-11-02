package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;

public class LoginAuthenticator extends Handler{
    public LoginAuthenticator(Handler next) {
        super(next);
    }
    @Override
    public boolean doHandle(LoginRequest request) {
        String inputUsername = request.getUsername();
        String inputPassword = request.getPassword();
        Validator validatorUser = new ValidatorUser(inputUsername);
        Validator validatorUserExist = new ValidatorUserCorrect(inputUsername, inputPassword);
        Validator validatorAdmin = new ValidatorAdmin(inputUsername);
        Validator validatorAdminExist = new ValidatorAdminCorrect(inputUsername, inputPassword);

        if (validatorUser.isCheck()) {
            if (validatorUserExist.isCheck()){
                return !validatorUser.isCheck();
            }
        } else if (validatorAdmin.isCheck()) {
            if (validatorAdminExist.isCheck()) {
                return !validatorAdminExist.isCheck();
            }
        }
        System.out.println("Incorrect Username or Password");
        return true;
    }

}
