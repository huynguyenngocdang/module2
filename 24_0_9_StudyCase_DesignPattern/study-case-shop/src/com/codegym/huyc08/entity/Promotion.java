package com.codegym.huyc08.entity;

import com.codegym.huyc08.service.RequestNewPromotion;

public class Promotion  {
    private int promotionId;
    private String promotionCode;
    private String promotionDateStart;
    private String promotionDateEnd;
    private double promotionAmount;
    private double promotionPercent;

    public Promotion() {
    }

    public Promotion(int promotionId, String promotionCode, String promotionDateStart, String promotionDateEnd, double promotionAmount, double promotionPercent) {
        this.promotionId = promotionId;
        this.promotionCode = promotionCode;
        this.promotionDateStart = promotionDateStart;
        this.promotionDateEnd = promotionDateEnd;
        this.promotionAmount = promotionAmount;
        this.promotionPercent = promotionPercent;
    }


    public int getPromotionId() {
        return promotionId;
    }


    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }


    public String getPromotionCode() {
        return promotionCode;
    }


    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }


    public String getPromotionDateStart() {
        return promotionDateStart;
    }


    public void setPromotionDateStart(String promotionDateStart) {
        this.promotionDateStart = promotionDateStart;
    }


    public String getPromotionDateEnd() {
        return promotionDateEnd;
    }


    public void setPromotionDateEnd(String promotionDateEnd) {
        this.promotionDateEnd = promotionDateEnd;
    }


    public double getPromotionAmount() {
        return promotionAmount;
    }


    public void setPromotionAmount(double promotionAmount) {
        this.promotionAmount = promotionAmount;
    }


    public double getPromotionPercent() {
        return promotionPercent;
    }


    public void setPromotionPercent(double promotionPercent) {
        this.promotionPercent = promotionPercent;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotionId=" + promotionId +
                ", promotionCode='" + promotionCode + '\'' +
                ", promotionDateStart='" + promotionDateStart + '\'' +
                ", promotionDateEnd='" + promotionDateEnd + '\'' +
                ", promotionAmount=" + promotionAmount +
                ", promotionPercent=" + promotionPercent +
                '}';
    }
}
