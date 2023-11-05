package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainLogin.LoginAuthentication;
import com.codegym.huyc08.service.chainLogin.LoginLogger;
import com.codegym.huyc08.service.chainLogin.LoginRedirect;
import com.codegym.huyc08.service.chainLogin.RequestLogin;

import java.util.Scanner;

public class CommandLogin implements Command {
    private final Scanner SCANNER;

    public CommandLogin() {
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Input your username");
        String username = SCANNER.next();
        System.out.println("Input your password");
        String password = SCANNER.next();

        //authentication - logger - navigator
        Handler navigator = new LoginRedirect(null);
        Handler logger = new LoginLogger(navigator);
        Handler authentication = new LoginAuthentication(logger);
        authentication.handle(new RequestLogin(username, password));
    }
}
