package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.CommandChangePromotionAmount;
import com.codegym.huyc08.service.CommandChangePromotionCode;
import com.codegym.huyc08.service.CommandChangePromotionDateEnd;
import com.codegym.huyc08.service.CommandChangePromotionDateStart;
import com.codegym.huyc08.service.CommandChangePromotionPercent;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetCurrentPromotionInformation;
import com.codegym.huyc08.service.CommandNotifyUsersAboutPromotion;
import com.codegym.huyc08.service.CommandRemoveCurrentPromotion;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.SingletonCurrentPromotion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdminPromotionProfile implements Navigator{

    private void displayMenuAdminPromotionManagement(){
        Scanner SCANNER = new Scanner(System.in);
        Menu menuPromotionProfile = new MenuTemplate("Promotion management");
        menuPromotionProfile.addMenuItem(new MenuItem("Exit", new CommandExit("Promotion profile management")));
        menuPromotionProfile.addMenuItem(new MenuItem("Get current promotion information", new CommandGetCurrentPromotionInformation()));
        menuPromotionProfile.addMenuItem(new MenuItem("Change promotion code", new CommandChangePromotionCode()));
        menuPromotionProfile.addMenuItem(new MenuItem("Change promotion start date", new CommandChangePromotionDateStart()));
        menuPromotionProfile.addMenuItem(new MenuItem("Change promotion end date", new CommandChangePromotionDateEnd()));
        menuPromotionProfile.addMenuItem(new MenuItem("Change promotion amount", new CommandChangePromotionAmount()));
        menuPromotionProfile.addMenuItem(new MenuItem("Change promotion percent", new CommandChangePromotionPercent()));
        menuPromotionProfile.addMenuItem(new MenuItem("Notify users about this promotion", new CommandNotifyUsersAboutPromotion(SingletonCurrentAdmin.getInstance().getCurrentAdmin().getUserId(), SingletonCurrentPromotion.getInstance().getCurrentPromotion())));
        menuPromotionProfile.addMenuItem(new MenuItem("Remove this promotion", new CommandRemoveCurrentPromotion()));
        int choice;
        try {
            do {
                menuPromotionProfile.display();
                choice = SCANNER.nextInt();
                menuPromotionProfile.runCommand(choice);
            } while (choice != AppConstant.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again");
            displayMenuAdminPromotionManagement();
        }


    }
    @Override
    public void navigate() {
        displayMenuAdminPromotionManagement();
    }
}
