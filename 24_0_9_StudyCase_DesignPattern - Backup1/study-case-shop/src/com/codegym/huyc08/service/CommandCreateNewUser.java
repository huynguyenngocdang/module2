package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainCreateNewUser.CreateNewUser;
import com.codegym.huyc08.service.chainCreateNewUser.RequestCreateNewUser;
import com.codegym.huyc08.service.chainCreateNewUser.ValidateUserExist;
import com.codegym.huyc08.service.chainCreateNewUser.ValidateUsername;

import java.util.Scanner;

public class CommandCreateNewUser implements Command {
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Input your username");
        String username = SCANNER.next();
        System.out.println("Input your password");
        String password = SCANNER.next();

        //Chain of responsibility create new user;
        Handler createNewUser = new CreateNewUser(null);
        Handler validateUsername = new ValidateUsername(createNewUser);
        Handler validateUserExist = new ValidateUserExist(validateUsername);
        validateUserExist.handle(new RequestCreateNewUser(username, password));

    }
}
