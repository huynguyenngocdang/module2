package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestModifyPromotionProfile implements RequestModifyPromotion {
    private int thisId;

    public RequestModifyPromotionProfile(int thisId) {
        this.thisId = thisId;
    }

    @Override
    public int getPromotionId() {
        return thisId;
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
