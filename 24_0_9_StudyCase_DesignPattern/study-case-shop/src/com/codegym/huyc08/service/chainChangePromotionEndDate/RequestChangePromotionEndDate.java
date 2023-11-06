package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.service.RequestPromotion;

public class RequestChangePromotionEndDate implements RequestPromotion {

    private String endDate;

    public RequestChangePromotionEndDate(String endDate) {

        this.endDate = endDate;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getString() {
        return endDate;
    }

    @Override
    public double getDoubleValue() {
        return 0;
    }
}
