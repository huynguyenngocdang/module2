package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDateBeforeDate;

public class ValidateEndDateAfterStartDate implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateEndDateAfterStartDate(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        String newEndDate = requestModifyPromotion.getPromotionDateEnd();
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
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next!=null){
            next.handle(requestModifyPromotion);
        }
    }
}
