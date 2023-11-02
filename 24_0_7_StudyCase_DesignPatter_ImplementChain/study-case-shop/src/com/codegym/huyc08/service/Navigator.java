package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.menu.NavigationUserProfile;

public class Navigator extends LoginHandler {


    public Navigator(LoginHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        System.out.println("Navigate to user Menu");
        Command navigationUserProfile = new NavigationUserProfile();
        navigationUserProfile.execute();
        return false;
    }
}
