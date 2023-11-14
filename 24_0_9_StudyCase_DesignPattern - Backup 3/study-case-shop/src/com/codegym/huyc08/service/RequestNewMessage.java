package com.codegym.huyc08.service;

public interface RequestNewMessage {
    String getMessage();

    void setMessage(String message);

    int getSenderId();

    void setSenderId(int senderId);

    int getReceiverId();

    void setReceiverId(int receiverId);
}
