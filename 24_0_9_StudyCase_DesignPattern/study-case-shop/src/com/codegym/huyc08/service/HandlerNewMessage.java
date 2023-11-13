package com.codegym.huyc08.service;

public interface HandlerNewMessage {
    boolean doHandle(RequestNewMessage requestNewMessage);
    void handle(RequestNewMessage requestNewMessage);
}
