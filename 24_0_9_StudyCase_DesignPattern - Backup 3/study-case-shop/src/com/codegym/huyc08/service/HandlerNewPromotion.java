package com.codegym.huyc08.service;

public interface HandlerNewPromotion {
    boolean doHandle(RequestNewPromotion requestPromotion);
    void handle(RequestNewPromotion requestPromotion);
}
