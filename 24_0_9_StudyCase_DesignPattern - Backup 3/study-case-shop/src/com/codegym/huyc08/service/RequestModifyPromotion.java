package com.codegym.huyc08.service;

public interface RequestModifyPromotion {
    int getPromotionId();
    String getPromotionCode();

    String getPromotionDateStart();

    String getPromotionDateEnd();

    double getPromotionAmount();

    double getPromotionPercent();

}
