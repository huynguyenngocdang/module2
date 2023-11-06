package com.codegym.huyc08.service.chainChangePromotionCode;

import com.codegym.huyc08.service.RequestPromotion;

public class RequestChangePromotionCode implements RequestPromotion {
    private int id;
    private String code;

    public RequestChangePromotionCode(int id, String code) {
        this.id = id;
        this.code = code;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getString() {
        return this.code;
    }

    @Override
    public double getDoubleValue() {
        return 0;
    }
}
