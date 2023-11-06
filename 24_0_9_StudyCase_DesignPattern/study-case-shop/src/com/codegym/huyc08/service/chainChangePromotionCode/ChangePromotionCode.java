package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;

public class ChangePromotionCode extends Subject implements HandlerPromotion {
    private HandlerPromotion next;

    public ChangePromotionCode(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        Observer observer = SingletonListPromotion.getInstance();
        addObserver(observer);
        SingletonCurrentPromotion.getInstance().getCurrentPromotion().setPromotionCode(requestPromotion.getString());
        notifyObserver();
        removeObserver(observer);
        return false;
    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next!=null) {
            next.handle(requestPromotion);
        }
    }
}
