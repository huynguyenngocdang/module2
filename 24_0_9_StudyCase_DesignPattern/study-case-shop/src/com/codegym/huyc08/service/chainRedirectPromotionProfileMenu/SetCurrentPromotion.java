package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;

public class SetCurrentPromotion implements HandlerPromotion {
    private HandlerPromotion next;

    public SetCurrentPromotion(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        try {
            int promotionId = requestPromotion.getId();
            SingletonCurrentPromotion.getInstance().setCurrentPromotion(promotionId);
            System.out.println("Set current promotion successfully");
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
            if(!doHandle(requestPromotion)) {
                return;
            }
            if(next != null) {
                next.handle(requestPromotion);
            }
    }
}
