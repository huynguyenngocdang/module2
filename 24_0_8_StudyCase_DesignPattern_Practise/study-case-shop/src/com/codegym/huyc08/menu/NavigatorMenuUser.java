package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandUserProfile;

import java.util.Scanner;

public class NavigatorMenuUser implements Navigator {
    private final Scanner SCANNER = new Scanner(System.in);
    private void navigateMenuUser() {
        Menu menuUser = new MenuMain();
        menuUser.addMenuItem(new MenuItem("Exit", new CommandExit("User")));
        menuUser.addMenuItem(new MenuItem("Profile", new CommandUserProfile()));
        int choice;
        do {
            menuUser.display();
            choice = SCANNER.nextInt();
            menuUser.runMenuItem(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        navigateMenuUser();
    }
}
