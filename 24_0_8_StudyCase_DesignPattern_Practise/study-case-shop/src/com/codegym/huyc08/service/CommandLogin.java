package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandLogin implements Command {
    private final Scanner SCANNER;

    public CommandLogin() {
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Input username");
        String inputUsername = SCANNER.next();
        System.out.println("Input password");
        String inputPassword = SCANNER.next();

        //authenticator - logger - redirect
        LoginNavigator navigator = new LoginNavigator(null);
        LoginLogger logger = new LoginLogger(navigator);
        LoginAuthenticator loginAuthenticator = new LoginAuthenticator(logger);
        loginAuthenticator.handle(new LoginRequest(inputUsername, inputPassword));
    }
}
