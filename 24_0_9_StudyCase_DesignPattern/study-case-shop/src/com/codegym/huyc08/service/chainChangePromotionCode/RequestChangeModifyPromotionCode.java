package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.service.RequestModifyPromotion;

public class RequestChangeModifyPromotionCode implements RequestModifyPromotion {
    private int id;
    private String code;

    public RequestChangeModifyPromotionCode(int id, String code) {
        this.id = id;
        this.code = code;
    }

    @Override
    public int getPromotionId() {
        return this.id;
    }

    @Override
    public String getPromotionCode() {
        return this.code;
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
