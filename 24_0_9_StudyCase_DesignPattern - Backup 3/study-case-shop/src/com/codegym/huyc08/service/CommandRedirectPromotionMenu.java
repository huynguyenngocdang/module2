package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.RedirectModifyPromotionProfileMenu;
import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.RequestModifyPromotionProfile;
import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.SetCurrentModifyPromotion;
import com.codegym.huyc08.service.chainRedirectPromotionProfileMenu.ValidatePromotionExistByModifyPromotion;

import java.util.Scanner;

public class CommandRedirectPromotionMenu implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input the promotion id");
        int promotionId = SCANNER.nextInt();

        //validate promotion exist - set current promotion - navigate to promotion profile
        HandlerModifyPromotion redirect = new RedirectModifyPromotionProfileMenu(null);
        HandlerModifyPromotion setPromotion = new SetCurrentModifyPromotion(redirect);
        HandlerModifyPromotion validatePromotionExist = new ValidatePromotionExistByModifyPromotion(setPromotion);
        validatePromotionExist.handle(new RequestModifyPromotionProfile(promotionId));
    }
}
