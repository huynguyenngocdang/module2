package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainCreateNewUser.ValidateUserExist;
import com.codegym.huyc08.service.chainCreateNewUser.ValidateUsername;
import com.codegym.huyc08.service.chainChangeUsername.ChangeUserUsername;
import com.codegym.huyc08.service.chainChangeUsername.RequestUserInformationChangeUserUsername;
import com.codegym.huyc08.service.chainChangeUsername.ValidateUsernameLikeAdmin;

import java.util.Scanner;

public class CommandChangeUserUsername implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Changing username");
        System.out.println("Input new username");
        String newUsername = SCANNER.next();

        //Validate user like admin - validate user exist - validate user follow regex - change username
        HandlerUserInformation changeUsername = new ChangeUserUsername(null);
        HandlerUserInformation validateUserRegex = new ValidateUsername(changeUsername);
        HandlerUserInformation validateUserExist = new ValidateUserExist(validateUserRegex);
        HandlerUserInformation validateUserLikeAdmin = new ValidateUsernameLikeAdmin(validateUserExist);
        validateUserLikeAdmin.handle(new RequestUserInformationChangeUserUsername(newUsername));
    }
}
