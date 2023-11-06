package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.service.RequestPromotion;

public class RequestChangePromotionStartDate implements RequestPromotion {

    private String startDate;

    public RequestChangePromotionStartDate( String startDate) {

        this.startDate = startDate;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getString() {
        return startDate;
    }

    @Override
    public double getDoubleValue() {
        return 0;
    }
}
