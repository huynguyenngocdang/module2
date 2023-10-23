package com.codegym.huy_c08.entity;

public class Promotion {
    private int promotionId;
    private String promotionCode;
    private String promotionDateStart;
    private String promotionDateEnd;
    private double promotionAmount;

    public Promotion() {
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

}
