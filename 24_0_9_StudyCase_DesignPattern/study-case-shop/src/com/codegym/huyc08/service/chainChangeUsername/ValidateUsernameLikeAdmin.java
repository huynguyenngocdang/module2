package com.codegym.huyc08.service.chainChangeUsername;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexString;

public class ValidateUsernameLikeAdmin implements HandlerUserInformation {
    private HandlerUserInformation nextHandlerUserInformation;

    public ValidateUsernameLikeAdmin(HandlerUserInformation nextHandlerUserInformation) {
        this.nextHandlerUserInformation = nextHandlerUserInformation;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        Validator validatorRegex = new ValidatorRegexString(requestUserInformation.getUsername(), Constants.ADMIN_REGEX);
        if(validatorRegex.isCheck()) {
            System.out.println("Can't make new name start with admin");
            return false;
        } else {
            System.out.println("Check username not similar to admin completed");
            return true;
        }
    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
            if(!doHandle(requestUserInformation)) {
                return;
            }
            if(nextHandlerUserInformation != null) {
                nextHandlerUserInformation.handle(requestUserInformation);
            }
    }
}
