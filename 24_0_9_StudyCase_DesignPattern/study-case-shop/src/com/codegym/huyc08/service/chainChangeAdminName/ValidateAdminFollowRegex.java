package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegex;

public class ValidateAdminFollowRegex implements Handler {
    private Handler next;

    public ValidateAdminFollowRegex(Handler next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Request request) {
        Validator validateAdminRegex = new ValidatorRegex(request.getUsername(), Constants.ADMIN_REGEX);
        if(validateAdminRegex.isCheck()) {
            System.out.println("Check admin regex successfully");
            return true;
        } else {
            System.out.println("Admin name must start with admin_ and at least 1 number");
            return false;
        }

    }

    @Override
    public void handle(Request request) {
        if(!doHandle(request)){
            return;
        }
        if(next != null) {
            next.handle(request);
        }
    }
}
