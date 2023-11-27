package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.menu.MenuAdmin;
import com.codegym.huyc08.menu.MenuUser;
import com.codegym.huyc08.menu.Navigator;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorRegexString;

public class LoginRedirect implements HandlerUserInformation {
    private HandlerUserInformation next;

    public LoginRedirect(HandlerUserInformation next) {
        this.next = next;
    }


    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        String username = requestUserInformation.getUsername();
        Validator validator = new ValidatorRegexString(username, AppConstant.USER_REGEX);
        Validator validator1 = new ValidatorRegexString(username, AppConstant.ADMIN_REGEX);
        if(validator.isCheck()) {
            Navigator menuUser = new MenuUser();
            System.out.println("Redirecting to Menu User");
            menuUser.navigate();
            return true;
        } else if(validator1.isCheck()) {
            Navigator menuAdmin = new MenuAdmin();
            System.out.println("Redirecting to Menu Admin");
            menuAdmin.navigate();
            return true;
        }
      return false;
    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
            if(!doHandle(requestUserInformation)) {
                return;
            }
            if (next != null) {
                next.handle(requestUserInformation);
            }
    }
}
