package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.CommandChangeUserActive;
import com.codegym.huyc08.service.CommandCreateNewPromotion;
import com.codegym.huyc08.service.CommandGetAllPromotionsInformation;
import com.codegym.huyc08.service.CommandGetAllUsersInformation;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandRedirectPromotionMenu;
import com.codegym.huyc08.service.CommandRemoveAllExpiredPromotion;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.SingletonCurrentUserListMessage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdmin implements Navigator{

    private void displayMenuAdmin() {
        Scanner SCANNER = new Scanner(System.in);
        Menu menuAdmin = new MenuTemplate("Menu Admin");
        menuAdmin.addMenuItem(new MenuItem("Exit", new CommandExit("Menu Admin")));
        menuAdmin.addMenuItem(new MenuItem("Admin profile", new MenuAdminProfile()));
        menuAdmin.addMenuItem(new MenuItem("Admin inbox", new MenuInbox(SingletonCurrentAdmin.getInstance().getCurrentAdmin().getUserId())));
        menuAdmin.addMenuItem(new MenuItem("Display all user information", new CommandGetAllUsersInformation()));
        menuAdmin.addMenuItem(new MenuItem("Banned/Unbanned user", new CommandChangeUserActive(SingletonCurrentAdmin.getInstance().getCurrentAdmin().getUserId())));
        menuAdmin.addMenuItem(new MenuItem("Get all promotion information", new CommandGetAllPromotionsInformation()));
        menuAdmin.addMenuItem(new MenuItem("Promotion profile", new CommandRedirectPromotionMenu()));
        menuAdmin.addMenuItem(new MenuItem("Remove all expired promotion", new CommandRemoveAllExpiredPromotion()));
        menuAdmin.addMenuItem(new MenuItem("Create new promotion", new CommandCreateNewPromotion()));

        int choice;
        try {
            do {
                menuAdmin.display();
                choice = SCANNER.nextInt();
                menuAdmin.runCommand(choice);
            } while (choice != AppConstant.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again");
            displayMenuAdmin();
        }


    }

    @Override
    public void navigate() {
        SingletonCurrentUserListMessage.getInstance().setCurrentUserMessage(SingletonCurrentAdmin.getInstance().getCurrentAdmin().getUserId());
        displayMenuAdmin();
    }
}
