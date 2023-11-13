package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonCurrentUserListProducts;

public class LoginLogger implements HandlerUserInformation {
    private HandlerUserInformation nextHandlerUserInformation;

    public LoginLogger(HandlerUserInformation nextHandlerUserInformation) {
        this.nextHandlerUserInformation = nextHandlerUserInformation;
    }

    @Override
    public boolean doHandle(RequestUserInformation requestUserInformation) {
        String username = requestUserInformation.getUsername();
        String password = requestUserInformation.getPassword();
        UserType userType = determineUserType(username);
        switch (userType) {
            case NORMAL:
                return handleNormalUser(username, password);
            case ADMIN:
                return handleAdmin(username, password);
            default:
                System.out.println("Invalid usertype");
                return false;
        }
    }

    @Override
    public void handle(RequestUserInformation requestUserInformation) {
        if(!doHandle(requestUserInformation)) {
            return;
        }
        if (nextHandlerUserInformation != null) {
            nextHandlerUserInformation.handle(requestUserInformation);
        }
    }
    private UserType determineUserType(String username) {
        if(username.startsWith("admin")){
            return UserType.ADMIN;
        } else {
            return UserType.NORMAL;
        }
    }
    private boolean handleNormalUser(String username, String password) {
        try {
            SingletonCurrentUser.getInstance().setCurrentUser(username, password);
            System.out.println("Set current user successfully");



            return true;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    private boolean handleAdmin(String username, String password) {
        try {
            SingletonCurrentAdmin.getInstance().setCurrentAdmin(username, password);
            System.out.println("Set current admin successfully");
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
