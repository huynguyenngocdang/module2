package com.codegym.huyc08.service.chainRemoveExpirePromotion;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.service.Confirm;
import com.codegym.huyc08.service.Confirmation;
import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDateBeforeDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisplayAllExpiredModifyPromotion implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;
    private SimpleDateFormat format;
    private List<Promotion> promotions;
    private List<Promotion> promotionsRemove;

    public DisplayAllExpiredModifyPromotion(HandlerModifyPromotion next) {
        this.next = next;
        this.format = new SimpleDateFormat(AppConstant.DATE_PATTERN_REGEX);
        this.promotions = SingletonListPromotion.getInstance().getPromotions();
        this.promotionsRemove = new ArrayList<>();
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        addExpiredPromotionToList();
        return handleExpiredPromotionList();
    }

    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
        if(!doHandle(requestModifyPromotion)){
            return;
        }
        if(next != null) {
            next.handle(requestModifyPromotion);
        }
    }
    private void addExpiredPromotionToList() {
        String todayZeroTime = format.format(new Date());
        for (int i = 0; i < promotions.size(); i++) {
            Promotion thisPromotion = promotions.get(i);
            String thisPromotionEndDate = promotions.get(i).getPromotionDateEnd();
            Validator validateEndDateBeforeToday = new ValidatorDateBeforeDate(thisPromotionEndDate, todayZeroTime);
            if (validateEndDateBeforeToday.isCheck()) {
                promotionsRemove.add(thisPromotion);
            }
        }
    }
    private boolean handleExpiredPromotionList() {
        if (promotionsRemove.isEmpty())  {
            System.out.println("There is no expired promotion to remove");
            return false;
        } else {
            for (Promotion promotion: promotionsRemove
                 ) {
                System.out.println("Removing expired promotion code " + promotion.getPromotionCode() + " with end date " + promotion.getPromotionDateEnd());
            }
            Confirm confirm = new Confirmation("remove these promotions");
            return confirm.isConfirm();
        }
    }

}
