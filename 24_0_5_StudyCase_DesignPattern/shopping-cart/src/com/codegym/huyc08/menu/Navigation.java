package com.codegym.huyc08.menu;

import com.codegym.huyc08.service.ChangeNameCommand;
import com.codegym.huyc08.service.ChangePasswordCommand;
import com.codegym.huyc08.service.CreateNewUserCommand;
import com.codegym.huyc08.service.LoginCommand;

import java.util.Scanner;

public class Navigation {
    Menu menuLogin = new Menu();
    Menu menuUserProfile = new Menu();
    private final Scanner SCANNER = new Scanner(System.in);
    public void navigationLogin(){
        menuLogin.addCommand(new LoginCommand("Login"));
        menuLogin.addCommand(new CreateNewUserCommand("Create new user"));
        int choice;
        do {
            menuLogin.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuLogin.executeCommand(choice);
        } while (choice!= 0);
    }

    public void navigationUser() {
        menuUserProfile.addCommand(new ChangeNameCommand("Change name"));
        menuUserProfile.addCommand(new ChangePasswordCommand("Change password"));
        int choice;
        do {
            menuUserProfile.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuUserProfile.executeCommand(choice);
        } while (choice!= 0);
    }
}
