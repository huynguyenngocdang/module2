package com.codegym.huyc08.service;

import com.codegym.huyc08.service.chainSendMessage.RequestANewMessage;
import com.codegym.huyc08.service.chainSendMessage.inputReceiverName;
import com.codegym.huyc08.service.chainSendMessage.sendNewMessage;

public class CommandCreateNewMessage implements Command{
    private int userId;

    public CommandCreateNewMessage(int userId) {
        this.userId = userId;
    }

    @Override
    public void execute() {
        HandlerNewMessage sendMessage = new sendNewMessage(null);
        HandlerNewMessage inputReceiverName = new inputReceiverName(sendMessage);
        RequestNewMessage requestNewMessage = new RequestANewMessage();
        requestNewMessage.setSenderId(userId);
        inputReceiverName.handle(requestNewMessage);
    }
}
