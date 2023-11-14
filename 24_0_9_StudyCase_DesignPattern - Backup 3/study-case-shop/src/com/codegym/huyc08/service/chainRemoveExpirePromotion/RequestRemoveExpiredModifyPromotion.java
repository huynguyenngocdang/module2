package com.codegym.huyc08.service.chainRemoveExpirePromotion;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestRemoveExpiredModifyPromotion implements RequestModifyPromotion {




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
        return 0;
    }

}
