package com.codegym.huyc08.service.chainChangeUsername;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegex;

public class ValidateUsernameLikeAdmin implements Handler {
    private Handler nextHandler;

    public ValidateUsernameLikeAdmin(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean doHandle(Request request) {
        Validator validatorRegex = new ValidatorRegex(request.getUsername(), Constants.ADMIN_REGEX);
        if(validatorRegex.isCheck()) {
            System.out.println("Can't make new name start with admin");
            return false;
        } else {
            System.out.println("Check username not similar to admin completed");
            return true;
        }
    }

    @Override
    public void handle(Request request) {
            if(!doHandle(request)) {
                return;
            }
            if(nextHandler != null) {
                nextHandler.handle(request);
            }
    }
}
