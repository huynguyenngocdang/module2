package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainLogin.LoginAuthentication;
import com.codegym.huyc08.service.chainLogin.LoginLogger;
import com.codegym.huyc08.service.chainLogin.LoginRedirect;
import com.codegym.huyc08.service.chainLogin.RequestUserInformationLogin;

import java.util.Scanner;

public class CommandLogin implements Command {
    private  Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        System.out.println("Input your username");
        String username = SCANNER.next();
        System.out.println("Input your password");
        String password = SCANNER.next();

        //authentication - logger - navigator
        HandlerUserInformation navigator = new LoginRedirect(null);
        HandlerUserInformation logger = new LoginLogger(navigator);
        HandlerUserInformation authentication = new LoginAuthentication(logger);
        authentication.handle(new RequestUserInformationLogin(username, password));
    }
}
