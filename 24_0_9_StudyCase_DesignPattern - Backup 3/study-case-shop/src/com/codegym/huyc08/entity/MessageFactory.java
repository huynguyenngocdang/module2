package com.codegym.huyc08.entity;

public class MessageFactory {
    public Message createMessage(int senderId, int receiverId, String message) {
        return new Message(senderId, receiverId, message);
    }
}
