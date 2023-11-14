package com.codegym.huyc08.service.chainChangePromotionAmount;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestChangeModifyPromotionAmount implements RequestModifyPromotion {
    private double inputAmount;

    public RequestChangeModifyPromotionAmount(double inputAmount) {
        this.inputAmount = inputAmount;
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
    public double getPromotionPercent() {
        return 0;
    }

    @Override
    public double getPromotionAmount() {
        return this.inputAmount;
    }


}
