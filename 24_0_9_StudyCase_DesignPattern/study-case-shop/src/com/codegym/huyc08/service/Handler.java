package com.codegym.huyc08.service;

public interface Handler {
    boolean doHandle(Request request);
    void handle(Request request);
}
