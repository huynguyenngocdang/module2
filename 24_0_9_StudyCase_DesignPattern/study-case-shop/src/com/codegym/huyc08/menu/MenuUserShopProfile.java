package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandUserAddNewProduct;
import com.codegym.huyc08.service.CommandUserDisplayBalance;
import com.codegym.huyc08.service.CommandUserDisplayProducts;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonCurrentUserListProducts;

import java.util.Scanner;

public class MenuUserShopProfile implements Navigator, Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuUserShopProfile(){
        Menu menuUserShopProfile = new MenuTemplate("User Shop Profile");
        menuUserShopProfile.addMenuItem(new MenuItem("Exit", new CommandExit("User shop profile")));
        menuUserShopProfile.addMenuItem(new MenuItem("Display user balance", new CommandUserDisplayBalance()));
        menuUserShopProfile.addMenuItem(new MenuItem("Display user products", new CommandUserDisplayProducts()));
        menuUserShopProfile.addMenuItem(new MenuItem("Create new product", new CommandUserAddNewProduct()));
        int choice;
        do {
            menuUserShopProfile.display();
            choice = SCANNER.nextInt();
            menuUserShopProfile.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        displayMenuUserShopProfile();
    }

    @Override
    public void execute() {
        navigate();
        SingletonCurrentUserListProducts.getInstance().generateCurrentUserProductList();
    }
}
