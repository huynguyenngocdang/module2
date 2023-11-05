package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandCreateNewUser;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandLogin;
import com.codegym.huyc08.service.UserManagement;

import java.util.Scanner;

public class NavigateMenuLogin implements Navigator{
    private final Scanner SCANNER = new Scanner(System.in);
    private void navigateMenuLogin(){
        Menu menuLogin = new MenuTemplate();
        menuLogin.addMenuItem(new MenuItem("Exit", new CommandExit("Login")));
        menuLogin.addMenuItem(new MenuItem("Login", new CommandLogin()));
        menuLogin.addMenuItem(new MenuItem("Create new user", new CommandCreateNewUser()));
        int choice;
        do {
            menuLogin.display();
            choice = SCANNER.nextInt();
            menuLogin.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        navigateMenuLogin();
    }
}
