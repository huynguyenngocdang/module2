package com.codegym.huyc08.backup.chainAddToCartBackup;

public interface HandlerAddToCartBk {
    boolean doHandle(RequestAddToCartBk requestAddToCartBk);
    void handle(RequestAddToCartBk requestAddToCartBk);
}
