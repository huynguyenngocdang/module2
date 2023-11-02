package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.menu.Menu;
import com.codegym.huyc08.menu.MenuItem;
import com.codegym.huyc08.menu.MenuMain;
import com.codegym.huyc08.menu.Navigator;

import java.util.Scanner;

public class CommandUserProfile implements Command, Navigator {
    private final Scanner SCANNER = new Scanner(System.in);
    private void navigateMenuUser() {
        Menu menuUserProfile = new MenuMain();
        menuUserProfile.addMenuItem(new MenuItem("Exit", new CommandExit("User")));
        menuUserProfile.addMenuItem(new MenuItem("Change username", new CommandChangeUserName()));
        menuUserProfile.addMenuItem(new MenuItem("Change user password", new CommandChangeUserPassword()));
        menuUserProfile.addMenuItem(new MenuItem("Change user balance", new CommandChangeUserBalance()));
        int choice;
        do {
            menuUserProfile.display();
            choice = SCANNER.nextInt();
            menuUserProfile.runMenuItem(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void execute() {
        navigateMenuUser();
    }

    @Override
    public void navigate() {

    }
}
