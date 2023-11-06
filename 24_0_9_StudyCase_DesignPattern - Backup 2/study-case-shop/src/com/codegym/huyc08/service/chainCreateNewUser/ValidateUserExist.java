package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserExist;

public class ValidateUserExist implements HandlerUserInformation {
    private HandlerUserInformation nextHandlerUserInformation;

    public ValidateUserExist(HandlerUserInformation nextHandlerUserInformation) {
        this.nextHandlerUserInformation = nextHandlerUserInformation;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        Validator validator = new ValidatorUserExist(requestUserInformation.getUsername());
        boolean isUserExist = validator.isCheck();
        if (isUserExist) {
            System.out.println("User already exist in database, get a new username");
            return false;
        } else {
            System.out.println("Check user exist completed");
            return true;
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
