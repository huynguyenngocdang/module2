package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandCreateNewUser;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandForgotPassword;
import com.codegym.huyc08.service.CommandLogin;

import java.util.Scanner;

public class MenuLogin implements Navigator {
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuLogin() {
        Menu menuLogin = new MenuTemplate("Menu login");
        menuLogin.addMenuItem(new MenuItem("Exit", new CommandExit("Menu login")));
        menuLogin.addMenuItem(new MenuItem("Login", new CommandLogin()));
        menuLogin.addMenuItem(new MenuItem("Create new user", new CommandCreateNewUser()));
        menuLogin.addMenuItem(new MenuItem("Forgot password", new CommandForgotPassword()));
        int choice;
        do {
            menuLogin.display();
            choice = SCANNER.nextInt();
            menuLogin.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        displayMenuLogin();
    }
}
