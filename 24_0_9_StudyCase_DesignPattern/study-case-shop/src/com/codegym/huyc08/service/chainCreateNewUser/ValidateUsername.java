package com.codegym.huyc08.service.chainCreateNewUser;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexString;

public class ValidateUsername implements HandlerUserInformation {
    private HandlerUserInformation nextHandlerUserInformation;

    public ValidateUsername(HandlerUserInformation nextHandlerUserInformation) {
        this.nextHandlerUserInformation = nextHandlerUserInformation;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        Validator validatorRegex = new ValidatorRegexString(requestUserInformation.getUsername(), AppConstant.USER_REGEX);
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
    public void handle(RequestUserInformation requestUserInformation) {
        if(!doHandle(requestUserInformation)){
            return;
        }
        if (nextHandlerUserInformation != null) {
            nextHandlerUserInformation.handle(requestUserInformation);
        }
    }
}
