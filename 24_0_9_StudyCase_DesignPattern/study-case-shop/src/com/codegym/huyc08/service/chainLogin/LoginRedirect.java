package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.menu.MenuAdmin;
import com.codegym.huyc08.menu.MenuUser;
import com.codegym.huyc08.menu.Navigator;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorRegex;

public class LoginRedirect implements Handler {
    private Handler next;

    public LoginRedirect(Handler next) {
        this.next = next;
    }


    @Override
    public boolean doHandle(Request request) {
        String username = request.getUsername();
        Validator validator = new ValidatorRegex(username, Constants.USER_REGEX);
        Validator validator1 = new ValidatorRegex(username, Constants.ADMIN_REGEX);
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
    public void handle(Request request) {
            if(!doHandle(request)) {
                return;
            }
            if (next != null) {
                next.handle(request);
            }
    }
}
