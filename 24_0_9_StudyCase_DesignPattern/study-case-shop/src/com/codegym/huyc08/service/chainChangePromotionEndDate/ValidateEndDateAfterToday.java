package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDateBeforeDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateEndDateAfterToday implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;

    public ValidateEndDateAfterToday(HandlerModifyPromotion next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_PATTERN_REGEX);
        String todayDateZeroTime = dateFormat.format(new Date());
        String newEndDate = requestModifyPromotion.getPromotionDateEnd();
        Validator validateEndDateAfterToday = new ValidatorDateBeforeDate(todayDateZeroTime, newEndDate );
        if(validateEndDateAfterToday.isCheck()) {
            System.out.println("Check end date after today successfully");
            return true;
        } else {
            System.out.println("End date is before today, please try again");
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
