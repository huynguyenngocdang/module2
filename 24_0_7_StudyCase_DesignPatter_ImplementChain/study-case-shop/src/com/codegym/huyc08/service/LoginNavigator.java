package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.NavigationUserProfile;

public class LoginNavigator extends Handler {


    public LoginNavigator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        System.out.println("Navigate to user Menu");
        NavigationUserProfile navigationUserProfile = new NavigationUserProfile();
        navigationUserProfile.navigationUserProfileMenu();
        return false;
    }
}
