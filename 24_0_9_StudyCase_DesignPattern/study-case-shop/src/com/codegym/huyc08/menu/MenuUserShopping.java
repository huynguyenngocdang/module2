package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetAllProductInformationInCart;
import com.codegym.huyc08.service.CommandGetAllProductsInformation;
import com.codegym.huyc08.service.CommandAddToCart;
import com.codegym.huyc08.service.CommandRemoveCartLine;

import java.util.Scanner;

public class MenuUserShopping  implements Navigator, Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuShopping() {
        Menu menuShopping = new MenuTemplate("Menu Shopping");
        menuShopping.addMenuItem(new MenuItem("Exit", new CommandExit("Menu Shopping")));
        menuShopping.addMenuItem(new MenuItem("Get all product information", new CommandGetAllProductsInformation()));
        menuShopping.addMenuItem(new MenuItem("Add to cart", new CommandAddToCart()));
        menuShopping.addMenuItem(new MenuItem("Check cart", new CommandGetAllProductInformationInCart()));
        menuShopping.addMenuItem(new MenuItem("Remove cart line", new CommandRemoveCartLine()));
        int choice;
        do {
            menuShopping.display();
            choice = SCANNER.nextInt();
            menuShopping.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        displayMenuShopping();
    }

    @Override
    public void execute() {
        navigate();
    }
}
