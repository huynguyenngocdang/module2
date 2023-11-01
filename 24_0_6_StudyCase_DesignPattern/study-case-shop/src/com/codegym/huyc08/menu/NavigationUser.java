package com.codegym.huyc08.menu;

import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.service.CurrentUser;
import com.codegym.huyc08.service.ExitCommand;

import java.util.List;
import java.util.Scanner;

public class NavigationUser {
    private CurrentUser currentUser;
    private List<NormalUser> users;
    Menu menuUser = new MenuMain("User");
    private final Scanner SCANNER = new Scanner(System.in);

    public NavigationUser(User currentUser, List<NormalUser> users) {
        this.currentUser = new CurrentUser(currentUser, users);
        this.users = users;
    }
    public void navigationUserMenu() {
        menuUser.addItem(new MenuItem("Exit", new ExitCommand("user profile menu")));
        menuUser.addItem(new MenuItem("User profile", new NavigationUserProfile(this.currentUser, this.users)));
        menuUser.addItem(new MenuItem("Shop profile", new NavigationUserShopProfile(this.currentUser, this.users)));
        int choice;
        do {
            menuUser.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuUser.executeMenuItem(choice);
        } while (choice!= 0);
    }


}
