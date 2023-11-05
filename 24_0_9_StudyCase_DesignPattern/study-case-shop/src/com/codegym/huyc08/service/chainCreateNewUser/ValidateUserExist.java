package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserExist;

public class ValidateUserExist implements Handler {
    private Handler nextHandler;

    public ValidateUserExist(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean doHandle(Request request) {
        Validator validator = new ValidatorUserExist(request.getUsername());
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
    public void handle(Request request) {
            if(!doHandle(request)){
                return;
            }
            if (nextHandler != null) {
                nextHandler.handle(request);
            }
    }
}
