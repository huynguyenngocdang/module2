package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegex;

public class ValidateUsername implements Handler {
    private Handler nextHandler;

    public ValidateUsername(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean doHandle(Request request) {
        Validator validatorRegex = new ValidatorRegex(request.getUsername(), Constants.USER_REGEX);
        boolean isUserFollowRegex = validatorRegex.isCheck();
        if (isUserFollowRegex) {
            System.out.println("Check username regex completed");
            return true;
        } else {
            System.out.println("Username must have at least 3 character");
            return false;
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
