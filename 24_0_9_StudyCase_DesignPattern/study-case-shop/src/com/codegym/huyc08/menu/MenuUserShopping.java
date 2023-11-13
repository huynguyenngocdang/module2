package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandAddToCart;
import com.codegym.huyc08.service.CommandCheckout;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetAllProductInformationInCart;
import com.codegym.huyc08.service.CommandGetAllProductsInformation;
import com.codegym.huyc08.service.CommandRemoveAllCartLine;
import com.codegym.huyc08.service.CommandRemoveCartLine;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserStatus;

import java.util.Scanner;

public class MenuUserShopping  implements Navigator, Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuShopping() {
        Menu menuShopping = new MenuTemplate("Menu Shopping");
        menuShopping.addMenuItem(new MenuItem("Exit", new CommandExit("Menu Shopping")));
        menuShopping.addMenuItem(new MenuItem("Get all product information", new CommandGetAllProductsInformation()));
        menuShopping.addMenuItem(new MenuItem("Add to cart", new CommandAddToCart()));
        menuShopping.addMenuItem(new MenuItem("Check items in cart", new CommandGetAllProductInformationInCart()));
        menuShopping.addMenuItem(new MenuItem("Remove cart line", new CommandRemoveCartLine()));
        menuShopping.addMenuItem(new MenuItem("Empty all cart", new CommandRemoveAllCartLine()));
        menuShopping.addMenuItem(new MenuItem("Check out", new CommandCheckout()));
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
        Validator validator = new ValidatorUserStatus();
        if(validator.isCheck()) {
            navigate();
        } else {
            System.out.println("You have been banned from using this function");
        }

    }
}
