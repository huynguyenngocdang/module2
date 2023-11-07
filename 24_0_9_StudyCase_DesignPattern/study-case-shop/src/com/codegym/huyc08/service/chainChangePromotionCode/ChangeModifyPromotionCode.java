package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;

public class ChangeModifyPromotionCode extends Subject implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ChangeModifyPromotionCode(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        Observer observer = SingletonListPromotion.getInstance();
        addObserver(observer);
        SingletonCurrentPromotion.getInstance().getCurrentPromotion().setPromotionCode(requestModifyPromotion.getPromotionCode());
        notifyObserver();
        removeObserver(observer);
        return false;
    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next!=null) {
            next.handle(requestModifyPromotion);
        }
    }
}
