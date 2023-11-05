package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.Handler;
import com.codegym.huyc08.service.Request;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorAdminCorrect;
import com.codegym.huyc08.service.ValidatorAdminExist;
import com.codegym.huyc08.service.ValidatorUserExist;
import com.codegym.huyc08.service.ValidatorUserCorrect;

import java.util.Scanner;

public class LoginAuthentication implements Handler {
    private Handler nextHandler;
    private static int loginAttempt;

    private final Scanner SCANNER = new Scanner(System.in);

    public LoginAuthentication(Handler nextHandler) {
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
        if(!doHandle(request)){
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
        if(loginAttempt < Constants.MAX_LOGIN_ATTEMPT) {
            Validator validateUserCorrect = new ValidatorUserCorrect(username, password);
            Validator validateUserExist = new ValidatorUserExist(username);
            boolean isUserExist = validateUserExist.isCheck();
            boolean isUserCorrect = validateUserCorrect.isCheck();
            if(isUserExist) {
                if(isUserCorrect) {
                    System.out.println("User authenticated");
                    return true;
                } else {
                    System.out.println("User wrong password");
                    ++loginAttempt;
                    System.out.println("You have enter wrong password " + loginAttempt + " times");
                    return false;
                }
            } else {
                System.out.println("User does not exist in database");
                return false;
            }
        } else {
            quitSystem();
            return false;
        }
    }
    private boolean handleAdmin(String username, String password) {
        if(loginAttempt < Constants.MAX_LOGIN_ATTEMPT) {
            Validator validateAdminCorrect = new ValidatorAdminCorrect(username, password);
            Validator validateAdminExist = new ValidatorAdminExist(username);
            boolean isAdminExist = validateAdminExist.isCheck();
            boolean isAdminCorrect = validateAdminCorrect.isCheck();
            if(isAdminExist) {
                if(isAdminCorrect) {
                    System.out.println("Admin authenticated");
                    return true;
                } else {
                    System.out.println("User wrong password");
                    ++loginAttempt;
                    System.out.println("You have enter wrong password " + loginAttempt + " times");
                    return false;
                }
            } else {
                System.out.println("Admin does not exist in database");
                return false;
            }
        } else {
            quitSystem();
            return false;
        }
    }
    private void quitSystem() {
        System.out.println("You have enter wrong password more than " + Constants.MAX_LOGIN_ATTEMPT + " times");
        System.out.println("The system is now quit");
        System.exit(0);
    }
}
