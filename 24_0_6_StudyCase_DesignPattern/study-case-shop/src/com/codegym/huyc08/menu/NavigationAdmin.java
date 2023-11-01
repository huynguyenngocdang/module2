package com.codegym.huyc08.menu;

import com.codegym.huyc08.entity.Admin;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.User;
import com.codegym.huyc08.service.CurrentAdmin;
import com.codegym.huyc08.service.CurrentUser;
import com.codegym.huyc08.service.ExitCommand;

import java.util.List;
import java.util.Scanner;

public class NavigationAdmin {
    private CurrentAdmin currentAdmin;
    private List<Admin> admins;
    private List<NormalUser> users;
    Menu menuUser = new MenuMain("Admin");
    private final Scanner SCANNER = new Scanner(System.in);

    public NavigationAdmin(User currentUser, List<Admin> admins, List<NormalUser> users) {
        this.currentAdmin = new CurrentAdmin(currentUser, admins);
        this.admins = admins;
        this.users = users;
    }

    public void navigationAdminMenu() {
        menuUser.addItem(new MenuItem("Exit", new ExitCommand("admin menu")));
        menuUser.addItem(new MenuItem("Admin profile" , new NavigationAdminProfile(this.currentAdmin, this.admins, this.users)));
        int choice;
        do {
            menuUser.displayMenu();
            System.out.println("Enter your choice");
            choice = SCANNER.nextInt();
            menuUser.executeMenuItem(choice);
        } while (choice!= 0);
    }
}
