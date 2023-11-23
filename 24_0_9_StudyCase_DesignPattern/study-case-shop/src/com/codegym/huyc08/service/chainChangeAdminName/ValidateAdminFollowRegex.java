package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegexString;

public class ValidateAdminFollowRegex implements HandlerUserInformation {
    private HandlerUserInformation next;

    public ValidateAdminFollowRegex(HandlerUserInformation next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        Validator validateAdminRegex = new ValidatorRegexString(requestUserInformation.getUsername(), AppConstant.ADMIN_REGEX);
        if(validateAdminRegex.isCheck()) {
            System.out.println("Check admin regex successfully");
            return true;
        } else {
            System.out.println("Admin name must start with admin_ and at least 1 number");
            return false;
        }

    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
        if(!doHandle(requestUserInformation)){
            return;
        }
        if(next != null) {
            next.handle(requestUserInformation);
        }
    }
}
