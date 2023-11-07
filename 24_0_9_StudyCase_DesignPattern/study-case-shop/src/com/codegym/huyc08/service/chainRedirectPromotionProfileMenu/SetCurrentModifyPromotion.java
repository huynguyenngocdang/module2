package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;

public class SetCurrentModifyPromotion implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public SetCurrentModifyPromotion(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        try {
            int promotionId = requestModifyPromotion.getPromotionId();
            SingletonCurrentPromotion.getInstance().setCurrentPromotion(promotionId);
            System.out.println("Set current promotion successfully");
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
            if(!doHandle(requestModifyPromotion)) {
                return;
            }
            if(next != null) {
                next.handle(requestModifyPromotion);
            }
    }
}
