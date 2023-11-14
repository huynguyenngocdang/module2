package com.codegym.huyc08.service.chainChangePromotionEndDate;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestChangeModifyPromotionEndDate implements RequestModifyPromotion {

    private String endDate;

    public RequestChangeModifyPromotionEndDate(String endDate) {

        this.endDate = endDate;
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
        return endDate;
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
