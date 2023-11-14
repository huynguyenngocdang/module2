package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;

public class ValidateStartDateBeforeEndDate implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateStartDateBeforeEndDate(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        String newStartDate = requestModifyPromotion.getPromotionDateStart();
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
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next!=null){
            next.handle(requestModifyPromotion);
        }
    }
}
