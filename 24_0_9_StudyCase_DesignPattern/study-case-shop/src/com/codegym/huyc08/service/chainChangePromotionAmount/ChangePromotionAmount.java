package com.codegym.huyc08.service.chainChangePromotionAmount;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;

public class ChangePromotionAmount extends Subject implements HandlerPromotion {
    private HandlerPromotion next;

    public ChangePromotionAmount(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        try {
            Observer observer = SingletonListPromotion.getInstance();
            addObserver(observer);
            SingletonCurrentPromotion.getInstance().getCurrentPromotion().setPromotionAmount(requestPromotion.getDoubleValue());
            notifyObserver();
            removeObserver(observer);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)) {
            return;
        }
        if(next!= null) {
            next.handle(requestPromotion);
        }
    }
}
