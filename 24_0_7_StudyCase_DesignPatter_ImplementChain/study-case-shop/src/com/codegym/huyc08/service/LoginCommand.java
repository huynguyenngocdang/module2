package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class LoginCommand implements Command {
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Input your username");
        String inputUsername = SCANNER.next();
        System.out.println("Input your password");
        String inputPassword = SCANNER.next();

        LoginNavigator navigator = new LoginNavigator(null);
        LoginLogger logger = new LoginLogger(navigator);
        LoginAuthenticator authenticator = new LoginAuthenticator(logger);
        authenticator.handle(new LoginRequest(inputUsername, inputPassword));

    }

}
