package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.menu.NavigateMenuAdmin;
import com.codegym.huyc08.menu.NavigateMenuUser;
import com.codegym.huyc08.menu.Navigator;

public class LoginNavigator extends LoginHandler{

    public LoginNavigator(LoginHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        String username = request.getUsername();
        Validator validateRegex = new ValidatorRegex(username, Constants.ADMIN_REGEX);

        if(validateRegex.isCheck()) {
            Navigator navigateAdminMenu = new NavigateMenuAdmin();
            navigateAdminMenu.navigate();

        } else {
            Navigator navigateUserMenu = new NavigateMenuUser();
            navigateUserMenu.navigate();

        }
        return false;
    }
}
