package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.SingletonCurrentUser;

public class LoginLogger implements Handler {
    private Handler nextHandler;

    public LoginLogger(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean doHandle(Request request) {
        String username = request.getUsername();
        String password = request.getPassword();
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
    public void handle(Request request) {
        if(!doHandle(request)) {
            return;
        }
        if (nextHandler != null) {
            nextHandler.handle(request);
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
