package com.codegym.huyc08.service.chainChangePromotionAmount;

import com.codegym.huyc08.service.RequestPromotion;

public class RequestChangePromotionAmount implements RequestPromotion {
    private double inputDouble;

    public RequestChangePromotionAmount(double inputDouble) {
        this.inputDouble = inputDouble;
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
        return this.inputDouble;
    }
}
