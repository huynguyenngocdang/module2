package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;

public class ValidateStartDateBeforeEndDate implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidateStartDateBeforeEndDate(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        String newStartDate = requestPromotion.getString();
        String currentEndDate = SingletonCurrentPromotion.getInstance().getCurrentPromotion().getPromotionDateEnd();
        Validator validateStartDateBeforeEndDate = new ValidatorDateBeforeDate(newStartDate, currentEndDate);
        if(validateStartDateBeforeEndDate.isCheck()){
            System.out.println("Check start date before end date successfully");
            return true;
        } else {
            System.out.println("Can't have start date after end date");
            return false;
        }

    }

    @Override
    public void handle(RequestPromotion requestPromotion) {
        if(!doHandle(requestPromotion)){
            return;
        }
        if(next!=null){
            next.handle(requestPromotion);
        }
    }
}
