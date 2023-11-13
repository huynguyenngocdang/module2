package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.service.CommandChangePromotionAmount;
import com.codegym.huyc08.service.CommandChangePromotionCode;
import com.codegym.huyc08.service.CommandChangePromotionDateEnd;
import com.codegym.huyc08.service.CommandChangePromotionDateStart;
import com.codegym.huyc08.service.CommandChangePromotionPercent;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandGetAllPromotionsInformation;
import com.codegym.huyc08.service.CommandGetCurrentPromotionInformation;
import com.codegym.huyc08.service.CommandNotifyUsersAboutPromotion;
import com.codegym.huyc08.service.CommandRemoveCurrentPromotion;
import com.codegym.huyc08.service.SingletonCurrentAdmin;
import com.codegym.huyc08.service.SingletonCurrentPromotion;

import java.util.Scanner;

public class MenuAdminPromotionProfile implements Navigator{
    private final Scanner SCANNER = new Scanner(System.in);
    private void displayMenuAdminPromotionManagement(){
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
        do {
            menuPromotionProfile.display();
            choice = SCANNER.nextInt();
            menuPromotionProfile.runCommand(choice);
        } while (choice != Constants.USER_EXIT_CHOICE);

    }
    @Override
    public void navigate() {
        displayMenuAdminPromotionManagement();
    }
}
