package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.ExitCommand;
import com.codegym.huyc08.service.LoginCommand;

import java.util.Scanner;

public class NavigationLogin {
    Menu menuLogin = new MenuMain("Login");
    private Scanner SCANNER = new Scanner(System.in);
    public void navigationLogin(){
        menuLogin.addItem(new MenuItem("Exit", new ExitCommand("Login")));
        menuLogin.addItem(new MenuItem("Login", new LoginCommand()));
        int choice;
        do {
            menuLogin.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuLogin.executeMenuItem(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
}