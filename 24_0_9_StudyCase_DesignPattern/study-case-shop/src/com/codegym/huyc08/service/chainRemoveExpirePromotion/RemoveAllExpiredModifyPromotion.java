package com.codegym.huyc08.service.chainRemoveExpirePromotion;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.service.HandlerModifyPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestModifyPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RemoveAllExpiredModifyPromotion extends Subject implements HandlerModifyPromotion {
    private HandlerModifyPromotion next;
    private SimpleDateFormat format;
    private List<Promotion> promotions;

    public RemoveAllExpiredModifyPromotion(HandlerModifyPromotion next) {
        this.next = next;
        this.format = new SimpleDateFormat(AppConstant.DATE_PATTERN_REGEX);
        this.promotions = SingletonListPromotion.getInstance().getPromotions();
    }

    @Override
    public boolean doHandle(RequestModifyPromotion requestModifyPromotion) {
        String todayZeroTime = format.format(new Date());
        Observer observer = SingletonListPromotion.getInstance();
        addObserver(observer);

        Iterator<Promotion> iterator = promotions.iterator();

        while (iterator.hasNext()) {
            Promotion thisPromotion = iterator.next();
            String thisPromotionEndDate = thisPromotion.getPromotionDateEnd();
            Validator validateEndDateBeforeToday = new ValidatorDateBeforeDate(thisPromotionEndDate, todayZeroTime);
            if (validateEndDateBeforeToday.isCheck()) {
                iterator.remove();
            }
        }
        notifyObserver();
        removeObserver(observer);
        return true;
    }
    @Override
    public void handle(RequestModifyPromotion requestModifyPromotion) {
            if(!doHandle(requestModifyPromotion)) {
                return;
            }
            if(next != null) {
                next.handle(requestModifyPromotion);
            }
    }
}
