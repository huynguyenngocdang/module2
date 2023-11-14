package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandChangeUserSelectProduct;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGenerateMonthlyCostReport;
import com.codegym.huyc08.service.CommandGenerateMontlyProfitReport;
import com.codegym.huyc08.service.CommandGenerateWeeklyCostReport;
import com.codegym.huyc08.service.CommandGenerateWeeklyProfitReport;
import com.codegym.huyc08.service.CommandRemoveUserProduct;
import com.codegym.huyc08.service.CommandUserAddNewProduct;
import com.codegym.huyc08.service.CommandUserDisplayBalance;
import com.codegym.huyc08.service.CommandUserDisplayProducts;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonCurrentUserListProducts;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserStatus;

import java.util.Scanner;

public class MenuUserShopProfile implements Navigator, Command {
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuUserShopProfile(){
        Menu menuUserShopProfile = new MenuTemplate("User Shop Profile");
        menuUserShopProfile.addMenuItem(new MenuItem("Exit", new CommandExit("User shop profile")));
        menuUserShopProfile.addMenuItem(new MenuItem("Display user balance", new CommandUserDisplayBalance()));
        menuUserShopProfile.addMenuItem(new MenuItem("Display user products", new CommandUserDisplayProducts()));
        menuUserShopProfile.addMenuItem(new MenuItem("Change your product information", new CommandChangeUserSelectProduct()));
        menuUserShopProfile.addMenuItem(new MenuItem("Create new product", new CommandUserAddNewProduct()));
        menuUserShopProfile.addMenuItem(new MenuItem("Remove your product", new CommandRemoveUserProduct()));
        menuUserShopProfile.addMenuItem(new MenuItem("Weekly profit report", new CommandGenerateWeeklyProfitReport()));
        menuUserShopProfile.addMenuItem(new MenuItem("Weekly cost report", new CommandGenerateWeeklyCostReport()));
        menuUserShopProfile.addMenuItem(new MenuItem("Monthly profit report", new CommandGenerateMontlyProfitReport()));
        menuUserShopProfile.addMenuItem(new MenuItem("Monthly cost report", new CommandGenerateMonthlyCostReport()));
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
        Validator validator = new ValidatorUserStatus();
        if(validator.isCheck()) {
            navigate();
        } else {
            System.out.println("You have been banned from using this function");
        }

    }
}
