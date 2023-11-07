package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.RequestNewPromotion;

public class RequestANewPromotion implements RequestNewPromotion {
    private int promotionId;
    private String promotionCode;
    private String promotionDateStart;
    private String promotionDateEnd;
    private double promotionAmount;
    private double promotionPercent;

    public RequestANewPromotion() {
    }

    @Override
    public int getPromotionId() {
        return promotionId;
    }

    @Override
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    @Override
    public String getPromotionCode() {
        return promotionCode;
    }

    @Override
    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    @Override
    public String getPromotionDateStart() {
        return promotionDateStart;
    }

    @Override
    public void setPromotionDateStart(String promotionDateStart) {
        this.promotionDateStart = promotionDateStart;
    }

    @Override
    public String getPromotionDateEnd() {
        return promotionDateEnd;
    }

    @Override
    public void setPromotionDateEnd(String promotionDateEnd) {
        this.promotionDateEnd = promotionDateEnd;
    }

    @Override
    public double getPromotionAmount() {
        return promotionAmount;
    }

    @Override
    public void setPromotionAmount(double promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    @Override
    public double getPromotionPercent() {
        return promotionPercent;
    }

    @Override
    public void setPromotionPercent(double promotionPercent) {
        this.promotionPercent = promotionPercent;
    }
}
