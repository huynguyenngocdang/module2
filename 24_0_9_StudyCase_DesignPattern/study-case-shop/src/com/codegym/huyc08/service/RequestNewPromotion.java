package com.codegym.huyc08.service;

public interface RequestNewPromotion {
    int getPromotionId();

    void setPromotionId(int promotionId);

    String getPromotionCode();

    void setPromotionCode(String promotionCode);

    String getPromotionDateStart();

    void setPromotionDateStart(String promotionDateStart);

    String getPromotionDateEnd();

    void setPromotionDateEnd(String promotionDateEnd);

    double getPromotionAmount();

    void setPromotionAmount(double promotionAmount);

    double getPromotionPercent();

    void setPromotionPercent(double promotionPercent);
}
