package com.codegym.huyc08.service;

public interface HandlerNewProduct {
    boolean doHandle(RequestNewProduct requestNewProduct);
    void handle(RequestNewProduct requestNewProduct);
}
