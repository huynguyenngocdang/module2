package com.codegym.huyc08.entity;

public class PromotionFactory {
    public Promotion createPromotion(int promotionId, String promotionCode, String promotionDateStart, String promotionDateEnd, double promotionAmount, double promotionPercent){
        return new Promotion(promotionId, promotionCode, promotionDateStart, promotionDateEnd, promotionAmount, promotionPercent);
    }
}
