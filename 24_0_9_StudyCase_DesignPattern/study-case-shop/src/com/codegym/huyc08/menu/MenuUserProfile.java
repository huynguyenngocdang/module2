package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandChangeUserBalance;
import com.codegym.huyc08.service.CommandChangeUserPassword;
import com.codegym.huyc08.service.CommandChangeUserUsername;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetCurrentUserInformation;

import java.util.Scanner;

public class MenuUserProfile implements Navigator, Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuUserProfile(){
        Menu menuUserProfile = new MenuTemplate("User profile");
        menuUserProfile.addMenuItem(new MenuItem("Exit", new CommandExit("User profile")));
        menuUserProfile.addMenuItem(new MenuItem("Current user info", new CommandGetCurrentUserInformation()));
        menuUserProfile.addMenuItem(new MenuItem("Change username", new CommandChangeUserUsername()));
        menuUserProfile.addMenuItem(new MenuItem("Change user password", new CommandChangeUserPassword()));
        menuUserProfile.addMenuItem(new MenuItem("Change user balance", new CommandChangeUserBalance()));
        int choice;
        do {
            menuUserProfile.display();
            choice = SCANNER.nextInt();
            menuUserProfile.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        displayMenuUserProfile();
    }

    @Override
    public void execute() {
        navigate();
    }
}
