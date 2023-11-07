package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;

public class ChangeModifyPromotionStartDate extends Subject implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ChangeModifyPromotionStartDate(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        try {
            Observer observer = SingletonListPromotion.getInstance();
            addObserver(observer);
            SingletonCurrentPromotion.getInstance().getCurrentPromotion().setPromotionDateStart(requestModifyPromotion.getPromotionDateStart());
            notifyObserver();
            removeObserver(observer);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next!= null) {
            next.handle(requestModifyPromotion);
        }
    }
}
