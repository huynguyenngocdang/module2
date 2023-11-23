package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.CommandChangeUserSelectProductDescription;
import com.codegym.huyc08.service.CommandChangeUserSelectProductManufacturer;
import com.codegym.huyc08.service.CommandChangeUserSelectProductName;
import com.codegym.huyc08.service.CommandChangeUserSelectProductPrice;
import com.codegym.huyc08.service.CommandChangeUserSelectProductQuantity;
import com.codegym.huyc08.service.CommandChangeUserSelectProductType;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetCurrentUserProductInformation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUserShopProductChange implements Navigator {

    private void displayMenuUserShopProductChange() {
        Scanner SCANNER = new Scanner(System.in);
        Menu menuShopProductChange = new MenuTemplate("Product information");
        menuShopProductChange.addMenuItem(new MenuItem("Exit", new CommandExit("Product information")));
        menuShopProductChange.addMenuItem(new MenuItem("Display current product information", new CommandGetCurrentUserProductInformation()));
        menuShopProductChange.addMenuItem(new MenuItem("Change product name", new CommandChangeUserSelectProductName()));
        menuShopProductChange.addMenuItem(new MenuItem("Change product type", new CommandChangeUserSelectProductType()));
        menuShopProductChange.addMenuItem(new MenuItem("Change product price", new CommandChangeUserSelectProductPrice()));
        menuShopProductChange.addMenuItem(new MenuItem("Change product quantity", new CommandChangeUserSelectProductQuantity()));
        menuShopProductChange.addMenuItem(new MenuItem("Change product manufacturer", new CommandChangeUserSelectProductManufacturer()));
        menuShopProductChange.addMenuItem(new MenuItem("Change product description", new CommandChangeUserSelectProductDescription()));
        int choice;
        try {
            do {
                menuShopProductChange.display();
                choice = SCANNER.nextInt();
                menuShopProductChange.runCommand(choice);
            } while (choice != AppConstant.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            displayMenuUserShopProductChange();
        }
    }

    @Override
    public void navigate() {
        displayMenuUserShopProductChange();
    }
}
