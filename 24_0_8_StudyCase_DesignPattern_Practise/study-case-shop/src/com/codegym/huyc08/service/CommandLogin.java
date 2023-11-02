package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandLogin implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input your username");
        String username = SCANNER.next();
        System.out.println("Input your password");
        String password = SCANNER.next();

        //authenticator - logger - navigator (chain of responsibility)
        LoginNavigator loginNavigator = new LoginNavigator(null);
        LoginLogger logger = new LoginLogger(loginNavigator);
        LoginAuthenticator authenticator = new LoginAuthenticator(logger);
        authenticator.handle(new LoginRequest(username, password));
    }
}
