package com.codegym.huyc08.service.chainLogin;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.UserType;
import com.codegym.huyc08.service.HandlerUserInformation;
import com.codegym.huyc08.service.RequestUserInformation;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.AdminValidValidator;
import com.codegym.huyc08.validator.ValidatorAdminExist;
import com.codegym.huyc08.validator.ValidatorUserNameExist;
import com.codegym.huyc08.validator.ValidatorUserCorrectLoginInformation;

import java.util.Scanner;

public class LoginAuthentication implements HandlerUserInformation {
    private HandlerUserInformation nextHandlerUserInformation;
    private static int loginAttempt;

    private final Scanner SCANNER = new Scanner(System.in);

    public LoginAuthentication(HandlerUserInformation nextHandlerUserInformation) {
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
        if(!doHandle(requestUserInformation)){
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
        if(loginAttempt < AppConstant.MAX_LOGIN_ATTEMPT) {
            Validator validateUserCorrect = new ValidatorUserCorrectLoginInformation(username, password);
            Validator validateUserExist = new ValidatorUserNameExist(username);
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
        if(loginAttempt < AppConstant.MAX_LOGIN_ATTEMPT) {
            Validator validateAdminCorrect = new AdminValidValidator(username, password);
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
        System.out.println("You have enter wrong password more than " + AppConstant.MAX_LOGIN_ATTEMPT + " times");
        System.out.println("The system is now quit");
        System.exit(0);
    }
}
