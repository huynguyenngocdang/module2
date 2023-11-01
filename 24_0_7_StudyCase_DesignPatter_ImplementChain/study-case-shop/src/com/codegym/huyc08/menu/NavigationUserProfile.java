package com.codegym.huyc08.menu;

import com.codegym.huyc08.service.ChangeUserNameCommand;
import com.codegym.huyc08.service.ChangeUserPasswordCommand;
import com.codegym.huyc08.service.ExitCommand;

import java.util.Scanner;

public class NavigationUserProfile {
    Menu menuProfile = new MenuMain("User profile");
    private final Scanner SCANNER = new Scanner(System.in);

    public void navigationUserProfileMenu() {
        menuProfile.addItem(new MenuItem("Exit", new ExitCommand("user profile menu")));
        menuProfile.addItem(new MenuItem("Change username", new ChangeUserNameCommand()));
        menuProfile.addItem(new MenuItem("Change user password", new ChangeUserPasswordCommand()));
        int choice;
        do {
            menuProfile.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuProfile.executeMenuItem(choice);
        } while (choice!= 0);
    }
}
