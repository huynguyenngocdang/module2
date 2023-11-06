package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.service.HandlerPromotion;
import com.codegym.huyc08.service.RequestPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;

public class ValidateEndDateAfterStartDate implements HandlerPromotion {
    private HandlerPromotion next;

    public ValidateEndDateAfterStartDate(HandlerPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestPromotion requestPromotion) {
        String newEndDate = requestPromotion.getString();
        String currentStartDate = SingletonCurrentPromotion.getInstance().getCurrentPromotion().getPromotionDateStart();
        Validator validateStartDateBeforeEndDate = new ValidatorDateBeforeDate(currentStartDate, newEndDate);
        if(validateStartDateBeforeEndDate.isCheck()){
            System.out.println("Check end date after start date successfully");
            return true;
        } else {
            System.out.println("Can't have end date before start date");
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
