package com.codegym.huyc08.service.chainChangePromotionStartDate;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestChangeModifyPromotionStartDate implements RequestModifyPromotion {

    private String startDate;

    public RequestChangeModifyPromotionStartDate(String startDate) {

        this.startDate = startDate;
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
        return startDate;
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
        return 0;
    }

}
