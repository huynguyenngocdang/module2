package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandChangeAdminPassword;
import com.codegym.huyc08.service.CommandChangeAdminUsername;
import com.codegym.huyc08.service.CommandExitMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdminProfile implements Navigator, Command {

    private void displayMenuAdminProfile(){
        Scanner SCANNER = new Scanner(System.in);
        Menu menuAdminProfile = new MenuTemplate("Admin Profile");
        menuAdminProfile.addMenuItem(new MenuItem("Exit", new CommandExitMenu("Admin profile")));
        menuAdminProfile.addMenuItem(new MenuItem("Change admin username", new CommandChangeAdminUsername()));
        menuAdminProfile.addMenuItem(new MenuItem("Change admin password", new CommandChangeAdminPassword()));
        int choice;
        try {
            do {
                menuAdminProfile.display();
                choice = SCANNER.nextInt();
                menuAdminProfile.runCommand(choice);
            } while (choice != AppConstant.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again");
            displayMenuAdminProfile();
        }

    }
    @Override
    public void execute() {
        navigate();
    }

    @Override
    public void navigate() {
        displayMenuAdminProfile();
    }
}
