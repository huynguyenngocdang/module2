package com.codegym.huyc08.menu;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.service.ChangeUserBalanceCommand;
import com.codegym.huyc08.service.ChangeUserNameCommand;
import com.codegym.huyc08.service.ChangeUserPasswordCommand;
import com.codegym.huyc08.service.CurrentUser;
import com.codegym.huyc08.service.ExitCommand;

import java.util.List;
import java.util.Scanner;

public class NavigationUserProfile implements Command {
    private CurrentUser currentUser;
    private List<NormalUser> users;
    Menu menuProfile = new MenuMain("User profile");
    private final Scanner SCANNER = new Scanner(System.in);

    public NavigationUserProfile(CurrentUser currentUser, List<NormalUser> users) {
        this.currentUser = currentUser;
        this.users = users;
    }
    public void navigationUserProfileMenu() {
        menuProfile.addItem(new MenuItem("Exit", new ExitCommand("user profile menu")));
        menuProfile.addItem(new MenuItem("Change username", new ChangeUserNameCommand(this.currentUser)));
        menuProfile.addItem(new MenuItem("Change user password", new ChangeUserPasswordCommand(this.currentUser)));
        menuProfile.addItem(new MenuItem("Recharge balance" , new ChangeUserBalanceCommand(this.currentUser)));
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
