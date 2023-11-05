package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.UserType;

public class LoginAuthenticator extends LoginHandler{
    public LoginAuthenticator(LoginHandler next) {
        super(next);
    }

    @Override
    public boolean doHandle(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        UserType userType = determineUserType(username);
        if(userType == UserType.ADMIN) {
            return handleAdminLogin(username, password);
        } else {
            return handleNormalUserLogin(username, password);
        }
    }
    private UserType determineUserType(String username) {
        if(username.startsWith("admin_")) {
            return UserType.ADMIN;
        } else {
            return UserType.NORMAL;
        }
    }
    private boolean handleAdminLogin(String username, String password) {
        // Handle admin login logic
        // ...
        Validator validateAdminExist = new ValidatorAdminExist(username);
            if(validateAdminExist.isCheck()) {
                Validator validateAdminCorrect = new ValidatorAdminCorrect(username, password);
                if (validateAdminCorrect.isCheck()) {
                    return false;
                } else {
                    System.out.println("Wrong admin password");
                }
            } else {
                System.out.println("This admin does not exist in database");
            }
        return true; // If login was not successful
    }

    private boolean handleNormalUserLogin(String username, String password) {
        // Handle normal user login logic
        // ...
            Validator validateUserExist = new ValidatorUserExist(username);
            if(validateUserExist.isCheck()) {
                Validator validateUserCorrect = new ValidatorUserCorrect(username, password);
                if (validateUserCorrect.isCheck()) {
                    return false;
                } else {
                    System.out.println("Wrong user password");
                }
            } else {
                System.out.println("This user does not exist in database");
            }
        return true; // If login was not successful
    }
}
