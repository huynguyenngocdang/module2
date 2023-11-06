package com.codegym.huyc08.service.chainChangeAdminName;

import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorAdminExist;

public class ValidateAdminExist implements HandlerUserInformation {
    private HandlerUserInformation next;

    public ValidateAdminExist(HandlerUserInformation next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        Validator validator = new ValidatorAdminExist(requestUserInformation.getUsername());
        if(validator.isCheck()) {
            System.out.println("Admin with this name already exist in database, change to new name");
            return false;
        } else {
            System.out.println("Check admin not exist in database successfully ");
            return true;
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
