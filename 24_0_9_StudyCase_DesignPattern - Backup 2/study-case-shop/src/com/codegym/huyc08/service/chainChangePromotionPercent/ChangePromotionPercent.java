package com.codegym.huyc08.service.chainChangePromotionPercent;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;

public class ChangePromotionPercent extends Subject implements HandlerPromotion {
    private HandlerPromotion next;

    public ChangePromotionPercent(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        try {
            Observer observer = SingletonListPromotion.getInstance();
            addObserver(observer);
            SingletonCurrentPromotion.getInstance().getCurrentPromotion().setPromotionPercent(requestPromotion.getDoubleValue());
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
