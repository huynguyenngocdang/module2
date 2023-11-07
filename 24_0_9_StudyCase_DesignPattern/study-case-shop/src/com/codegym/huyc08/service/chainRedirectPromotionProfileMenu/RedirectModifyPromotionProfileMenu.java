package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.menu.MenuAdminPromotionProfile;
import com.codegym.huyc08.menu.Navigator;
import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;

public class RedirectModifyPromotionProfileMenu implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public RedirectModifyPromotionProfileMenu(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        try {
            Navigator navigator = new MenuAdminPromotionProfile();
            navigator.navigate();
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next != null) {
            next.handle(requestModifyPromotion);
        }
    }
}
