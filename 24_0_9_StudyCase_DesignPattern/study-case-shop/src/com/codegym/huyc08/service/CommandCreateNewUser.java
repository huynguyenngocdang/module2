package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainCreateNewUser.CreateNewUser;
import com.codegym.huyc08.service.chainCreateNewUser.RequestUserInformationCreateNewUser;
import com.codegym.huyc08.service.chainCreateNewUser.ValidateUserExist;
import com.codegym.huyc08.service.chainCreateNewUser.ValidateUsername;

import java.util.Scanner;

public class CommandCreateNewUser implements Command {
    private  Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        System.out.println("Input your username");
        String username = SCANNER.next();
        System.out.println("Input your password");
        String password = SCANNER.next();

        //Chain of responsibility create new user;
        HandlerUserInformation createNewUser = new CreateNewUser(null);
        HandlerUserInformation validateUsername = new ValidateUsername(createNewUser);
        HandlerUserInformation validateUserExist = new ValidateUserExist(validateUsername);
        validateUserExist.handle(new RequestUserInformationCreateNewUser(username, password));

    }
}
