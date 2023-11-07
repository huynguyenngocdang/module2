package com.codegym.huyc08.service.chainChangePromotionPercent;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestChangeModifyPromotionPercent implements RequestModifyPromotion {
    private double inputPromotionPercent;

    public RequestChangeModifyPromotionPercent(double inputPromotionPercent) {
        this.inputPromotionPercent = inputPromotionPercent;
    }

    @Override
    public int getPromotionId() {
        return 0;
    }

    @Override
    public String getPromotionCode() {
        return null;
    }

    @Override
    public String getPromotionDateStart() {
        return null;
    }

    @Override
    public String getPromotionDateEnd() {
        return null;
    }

    @Override
    public double getPromotionAmount() {
        return 0;
    }



    @Override
    public double getPromotionPercent() {
        return inputPromotionPercent;
    }
}
