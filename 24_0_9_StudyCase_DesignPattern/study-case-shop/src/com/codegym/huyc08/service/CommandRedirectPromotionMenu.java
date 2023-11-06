package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.RedirectPromotionProfileMenu;
import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.RequestPromotionProfile;
import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.SetCurrentPromotion;
import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.ValidatePromotionExistByPromotion;

import java.util.Scanner;

public class CommandRedirectPromotionMenu implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input the promotion id");
        int promotionId = SCANNER.nextInt();

        //validate promotion exist - set current promotion - navigate to promotion profile
        HandlerPromotion redirect = new RedirectPromotionProfileMenu(null);
        HandlerPromotion setPromotion = new SetCurrentPromotion(redirect);
        HandlerPromotion validatePromotionExist = new ValidatePromotionExistByPromotion(setPromotion);
        validatePromotionExist.handle(new RequestPromotionProfile(promotionId));
    }
}
