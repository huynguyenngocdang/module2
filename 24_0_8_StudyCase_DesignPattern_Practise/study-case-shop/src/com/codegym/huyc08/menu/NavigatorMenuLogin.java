package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandLogin;

import java.util.Scanner;

public class NavigatorMenuLogin implements Navigator {
    private final Scanner SCANNER = new Scanner(System.in);
    private void navigateMenuLogin() {
        Menu menuLogin = new MenuMain();
        menuLogin.addMenuItem(new MenuItem("Exit", new CommandExit("Login Menu")));
        menuLogin.addMenuItem(new MenuItem("Login", new CommandLogin()));
        int choice;
        do {
            menuLogin.display();
            choice = SCANNER.nextInt();
            menuLogin.runMenuItem(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        navigateMenuLogin();
    }
}
