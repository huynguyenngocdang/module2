package com.codegym.huyc08.service;

public interface HandlerUserInformation {
    boolean doHandle(RequestUserInformation requestUserInformation);
    void handle(RequestUserInformation requestUserInformation);
}
