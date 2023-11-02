package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.menu.Navigator;
import com.codegym.huyc08.menu.NavigatorMenuUser;

public class LoginNavigator extends Handler {

    public LoginNavigator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        String inputUsername = request.getUsername();

        Validator validatorUser = new ValidatorUser(inputUsername);
        Validator validatorAdmin = new ValidatorAdmin(inputUsername);
        if(validatorUser.isCheck()) {
            System.out.println("Navigate to user Menu");
            Navigator navigationUserProfile = new NavigatorMenuUser();
            navigationUserProfile.navigate();
            return false;
        } else if (validatorAdmin.isCheck()) {
            System.out.println("Navigate to admin Menu");
            return false;
        }
        return true;
    }
}