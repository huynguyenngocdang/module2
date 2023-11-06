package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.menu.MenuAdminPromotionProfile;
import com.codegym.huyc08.menu.Navigator;
import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;

public class RedirectPromotionProfileMenu implements HandlerPromotion {
    private HandlerPromotion next;

    public RedirectPromotionProfileMenu(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        try {
            Navigator navigator = new MenuAdminPromotionProfile();
            navigator.navigate();
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next != null) {
            next.handle(requestPromotion);
        }
    }
}
