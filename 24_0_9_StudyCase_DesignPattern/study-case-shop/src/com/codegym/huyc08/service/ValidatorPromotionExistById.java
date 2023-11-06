package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Promotion;

import java.util.List;

public class ValidatorPromotionExistById implements Validator{
    private List<Promotion> promotions;
    private int promotionId;

    public ValidatorPromotionExistById(int promotionId) {
        this.promotions = SingletonListPromotion.getInstance().getPromotions();
        this.promotionId = promotionId;
    }



    @Override
    public boolean isCheck() {
        for (Promotion promotion: promotions
             ) {
            if(promotion.getPromotionId() == promotionId) {
                return true;
            }
        }
        return false;
    }
}
