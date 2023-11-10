package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandUserShop;
import com.codegym.huyc08.service.CommandUserShopProfile;
import com.codegym.huyc08.service.SingletonCurrentUser;

import java.util.Scanner;

public class MenuUser implements Navigator{
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuUser() {
        Menu menuUser = new MenuTemplate("Menu User");
        menuUser.addMenuItem(new MenuItem("Exit", new CommandExit("Menu user")));
        menuUser.addMenuItem(new MenuItem("User profile", new MenuUserProfile()));
        menuUser.addMenuItem(new MenuItem("Shop profile", new MenuUserShopProfile()));
        menuUser.addMenuItem(new MenuItem("Shopping", new MenuUserShopping()));
        int choice;
        do {
            String username = SingletonCurrentUser.getInstance().getCurrentUser().getUsername();
            System.out.println("Welcome " + username);
            menuUser.display();
            choice = SCANNER.nextInt();
            menuUser.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        displayMenuUser();
    }
}
