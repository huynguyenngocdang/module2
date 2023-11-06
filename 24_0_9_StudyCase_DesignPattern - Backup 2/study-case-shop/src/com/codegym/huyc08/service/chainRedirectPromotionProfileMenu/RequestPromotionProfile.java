package com.codegym.huyc08.service.chainRedirectPromotionProfileMenu;

import com.codegym.huyc08.service.RequestPromotion;

public class RequestPromotionProfile implements RequestPromotion {
    private int thisId;

    public RequestPromotionProfile(int thisId) {
        this.thisId = thisId;
    }

    @Override
    public int getId() {
        return thisId;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public double getDoubleValue() {
        return 0;
    }
}
