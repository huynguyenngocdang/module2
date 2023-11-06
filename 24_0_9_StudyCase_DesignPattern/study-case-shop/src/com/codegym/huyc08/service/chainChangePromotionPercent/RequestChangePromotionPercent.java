package com.codegym.huyc08.service.chainChangePromotionPercent;

import com.codegym.huyc08.service.RequestPromotion;

public class RequestChangePromotionPercent implements RequestPromotion {
    private double doubleInput;

    public RequestChangePromotionPercent(double doubleInput) {
        this.doubleInput = doubleInput;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public double getDoubleValue() {
        return doubleInput;
    }
}
