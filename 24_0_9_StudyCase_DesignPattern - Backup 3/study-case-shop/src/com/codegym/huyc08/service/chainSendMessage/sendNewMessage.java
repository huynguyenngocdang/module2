package com.codegym.huyc08.service.chainSendMessage;

import com.codegym.huyc08.entity.Message;
import com.codegym.huyc08.entity.MessageFactory;
import com.codegym.huyc08.service.HandlerNewMessage;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestNewMessage;
import com.codegym.huyc08.service.SingletonListMessage;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.Subject;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserNameExist;

import java.util.Scanner;

public class sendNewMessage extends Subject implements HandlerNewMessage {
    private HandlerNewMessage next;
    private Scanner SCANNER = new Scanner(System.in);

    public sendNewMessage(HandlerNewMessage next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewMessage requestNewMessage) {
        try {
            System.out.println("Input your message");
            String message = SCANNER.nextLine();
            requestNewMessage.setMessage(message);

            MessageFactory factory = new MessageFactory();
            Message newMessage = factory.createMessage(requestNewMessage.getSenderId(), requestNewMessage.getReceiverId(), requestNewMessage.getMessage());

            Observer observer = SingletonListMessage.getInstance();
            addObserver(observer);
            SingletonListMessage.getInstance().getMessages().add(newMessage);
            notifyObserver();
            removeObserver(observer);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public void handle(RequestNewMessage requestNewMessage) {
        if(!doHandle(requestNewMessage)){
            return;
        }
        if(next != null) {
            next.handle(requestNewMessage);
        }
    }
}
