package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandChangeUserAddress;
import com.codegym.huyc08.service.CommandChangeUserBalance;
import com.codegym.huyc08.service.CommandChangeUserPassword;
import com.codegym.huyc08.service.CommandChangeUserUsername;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetCurrentUserInformation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUserProfile implements Navigator, Command {

    private void displayMenuUserProfile(){
        Scanner SCANNER = new Scanner(System.in);
        Menu menuUserProfile = new MenuTemplate("User profile");
        menuUserProfile.addMenuItem(new MenuItem("Exit", new CommandExit("User profile")));
        menuUserProfile.addMenuItem(new MenuItem("Current user info", new CommandGetCurrentUserInformation()));
        menuUserProfile.addMenuItem(new MenuItem("Change username", new CommandChangeUserUsername()));
        menuUserProfile.addMenuItem(new MenuItem("Change user password", new CommandChangeUserPassword()));
        menuUserProfile.addMenuItem(new MenuItem("Change user balance", new CommandChangeUserBalance()));
        menuUserProfile.addMenuItem(new MenuItem("Change user address", new CommandChangeUserAddress()));
        int choice;
        try {
            do {
                menuUserProfile.display();
                choice = SCANNER.nextInt();
                menuUserProfile.runCommand(choice);
            } while (choice != Constants.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            displayMenuUserProfile();
        }

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
