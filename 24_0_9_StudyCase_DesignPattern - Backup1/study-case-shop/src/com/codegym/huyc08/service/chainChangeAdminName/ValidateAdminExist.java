package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorAdminExist;

public class ValidateAdminExist implements Handler {
    private Handler next;

    public ValidateAdminExist(Handler next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Request request) {
        Validator validator = new ValidatorAdminExist(request.getUsername());
        if(validator.isCheck()) {
            System.out.println("Admin with this name already exist in database, change to new name");
            return false;
        } else {
            System.out.println("Check admin not exist in database successfully ");
            return true;
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
