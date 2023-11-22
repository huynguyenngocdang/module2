package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainForgotPassword.RequestUserInformationForgotPassword;
import com.codegym.huyc08.service.chainForgotPassword.ValidateUserForgotPasswordExist;
import com.codegym.huyc08.service.chainForgotPassword.messageAdminForgotPassword;

import java.util.Scanner;

public class CommandForgotPassword implements Command{
    private  Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        System.out.println("Input your username");
        String username = SCANNER.nextLine();

        HandlerUserInformation messageAdmin = new messageAdminForgotPassword(null);
        HandlerUserInformation validateUserExist = new ValidateUserForgotPasswordExist(messageAdmin);
        validateUserExist.handle(new RequestUserInformationForgotPassword(username));
    }
}
