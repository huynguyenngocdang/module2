package com.codegym.huyc08.service;

public interface HandlerAddToCart {
    boolean doHandle(RequestAddToCart requestAddToCart);
    void handle(RequestAddToCart requestAddToCart);
}
