package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Promotion;

import java.util.List;

public class ValidatorPromotionExistByCode implements Validator{
    private List<Promotion> promotions;

    private String promotionCode;


    public ValidatorPromotionExistByCode(String promotionCode) {
        this.promotions = SingletonListPromotion.getInstance().getPromotions();
        this.promotionCode = promotionCode;
    }

    @Override
    public boolean isCheck() {
        for (Promotion promotion: promotions
             ) {
            if(promotion.getPromotionCode().equals(promotionCode)) {
                return true;
            }
        }
        return false;
    }
}
