package com.codegym.huyc08.menu;

import com.codegym.huyc08.service.CreateNewUserCommand;
import com.codegym.huyc08.service.ExitCommand;
import com.codegym.huyc08.service.LoginCommand;

import java.util.Scanner;

public class NavigationLogin {
    Menu menuLogin = new MenuMain();
    private final Scanner SCANNER = new Scanner(System.in);
    public void navigationLogin() {
        menuLogin.addItem(new MenuItem("Exit", new ExitCommand("login menu")));
        menuLogin.addItem(new MenuItem("Login", new LoginCommand()));
        menuLogin.addItem(new MenuItem("Create new user", new CreateNewUserCommand()));
        int choice;
        do {
            menuLogin.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuLogin.executeMenuItem(choice);
        } while (choice!= 0);
    }
}
