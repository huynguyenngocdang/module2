package com.codegym.huyc08.service.chainForgotPassword;

import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorUserNameExist;

public class ValidateUserForgotPasswordExist implements HandlerUserInformation {
    private HandlerUserInformation nextHandlerUserInformation;

    public ValidateUserForgotPasswordExist(HandlerUserInformation nextHandlerUserInformation) {
        this.nextHandlerUserInformation = nextHandlerUserInformation;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        Validator validator = new ValidatorUserNameExist(requestUserInformation.getUsername());
        boolean isUserExist = validator.isCheck();
        if (isUserExist) {
            System.out.println("Check user exist completed");
            return true;
        } else {
            System.out.println("Username does not exist in database");
            return false;
        }
    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
        if(!doHandle(requestUserInformation)){
            return;
        }
        if (nextHandlerUserInformation != null) {
            nextHandlerUserInformation.handle(requestUserInformation);
        }
    }
}
