package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandChangeUserActive;
import com.codegym.huyc08.service.CommandGetAllUsersInformation;
import com.codegym.huyc08.service.CommandExit;

import java.util.Scanner;

public class MenuAdmin implements Navigator{
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuAdmin() {
        Menu menuAdmin = new MenuTemplate("Menu Admin");
        menuAdmin.addMenuItem(new MenuItem("Exit", new CommandExit("Menu Admin")));
        menuAdmin.addMenuItem(new MenuItem("Admin profile", new MenuAdminProfile()));
        menuAdmin.addMenuItem(new MenuItem("Display all user information", new CommandGetAllUsersInformation()));
        menuAdmin.addMenuItem(new MenuItem("Banned/Unbanned user", new CommandChangeUserActive()));

        int choice;
        do {
            menuAdmin.display();
            choice = SCANNER.nextInt();
            menuAdmin.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);

    }

    @Override
    public void navigate() {
        displayMenuAdmin();
    }
}
