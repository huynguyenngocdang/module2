package com.codegym.huyc08.service.chainSendMessage;

import com.codegym.huyc08.service.RequestNewMessage;

public class RequestANewMessage implements RequestNewMessage {
    private int senderId;
    private int receiverId;
    private String message;
    private String dateCreated;

    @Override
    public int getSenderId() {
        return senderId;
    }

    @Override
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Override
    public int getReceiverId() {
        return receiverId;
    }

    @Override
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
