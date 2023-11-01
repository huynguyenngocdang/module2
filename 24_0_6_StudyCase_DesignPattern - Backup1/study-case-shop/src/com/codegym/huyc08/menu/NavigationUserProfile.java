package com.codegym.huyc08.menu;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.service.ChangeUserNameCommand;
import com.codegym.huyc08.service.ChangeUserPassword;
import com.codegym.huyc08.service.CurrentUser;
import com.codegym.huyc08.service.ExitCommand;

import java.util.List;
import java.util.Scanner;

public class NavigationUserProfile {
    private CurrentUser currentUser;
    private List<NormalUser> users;
    Menu menuProfile = new MenuMain();
    private final Scanner SCANNER = new Scanner(System.in);

    public NavigationUserProfile(User currentUser, List<NormalUser> users) {
        this.currentUser = new CurrentUser(currentUser, users);
        this.users = users;
    }
    public void navigationUserProfile() {
        menuProfile.addItem(new MenuItem("Exit", new ExitCommand("user profile menu")));
        menuProfile.addItem(new MenuItem("Change username", new ChangeUserNameCommand(this.currentUser)));
        menuProfile.addItem(new MenuItem("Change user password", new ChangeUserPassword(this.currentUser)));
        int choice;
        do {
            menuProfile.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuProfile.executeMenuItem(choice);
        } while (choice!= 0);
    }
}
