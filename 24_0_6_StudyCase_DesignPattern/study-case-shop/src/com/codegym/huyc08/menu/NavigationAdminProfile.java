package com.codegym.huyc08.menu;

import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.service.ChangeAdminNameCommand;
import com.codegym.huyc08.service.ChangeAdminPasswordCommand;
import com.codegym.huyc08.service.ChangeUserBalanceCommand;
import com.codegym.huyc08.service.ChangeUserNameCommand;
import com.codegym.huyc08.service.ChangeUserPasswordCommand;
import com.codegym.huyc08.service.CurrentAdmin;
import com.codegym.huyc08.service.CurrentUser;
import com.codegym.huyc08.service.ExitCommand;

import java.util.List;
import java.util.Scanner;

public class NavigationAdminProfile implements Command {
    private CurrentAdmin currentAdmin;
    private List<Admin> admins;
    private List<NormalUser> users;
    Menu menuProfile = new MenuMain("User profile");
    private final Scanner SCANNER = new Scanner(System.in);

    public NavigationAdminProfile(CurrentAdmin currentAdmin,List<Admin> admins , List<NormalUser> users) {
        this.currentAdmin = currentAdmin;
        this.admins = admins;
        this.users = users;
    }
    public void navigationUserProfileMenu() {
        menuProfile.addItem(new MenuItem("Exit", new ExitCommand("user profile menu")));
        menuProfile.addItem(new MenuItem("Change username", new ChangeAdminNameCommand(this.currentAdmin)));
        menuProfile.addItem(new MenuItem("Change user password", new ChangeAdminPasswordCommand(this.currentAdmin)));
        int choice;
        do {
            menuProfile.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuProfile.executeMenuItem(choice);
        } while (choice!= 0);
    }

    @Override
    public void execute() {
        navigationUserProfileMenu();
    }
}
