package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.CommandExitMenu;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonCurrentUserListMessage;
import com.codegym.huyc08.service.SingletonShoppingCart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUser implements Navigator{

    private void displayMenuUser() {

        Scanner SCANNER = new Scanner(System.in);
        Menu menuUser = new MenuTemplate("Menu User");
        menuUser.addMenuItem(new MenuItem("Exit", new CommandExitMenu("Menu user")));
        menuUser.addMenuItem(new MenuItem("User profile", new MenuUserProfile()));
        menuUser.addMenuItem(new MenuItem("Inbox", new MenuInbox(SingletonCurrentUser.getInstance().getCurrentUser().getUserId())));
        menuUser.addMenuItem(new MenuItem("Shop profile", new MenuUserShopProfile()));
        menuUser.addMenuItem(new MenuItem("Shopping", new MenuUserShopping()));
        int choice;
        try {
            do {
                String username = SingletonCurrentUser.getInstance().getCurrentUser().getUsername();
                System.out.println("Welcome " + username);
                menuUser.display();
                choice = SCANNER.nextInt();
                menuUser.runCommand(choice);
            } while (choice != AppConstant.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            displayMenuUser();
        }

    }
    @Override
    public void navigate() {
        SingletonCurrentUserListMessage.getInstance().setCurrentUserMessage(SingletonCurrentUser.getInstance().getCurrentUser().getUserId());
        SingletonShoppingCart.getInstance().emptyCart();
        displayMenuUser();
    }
}
