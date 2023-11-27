package com.codegym.huyc08.service.chainSendMessage;

import com.codegym.huyc08.service.HandlerNewMessage;
import com.codegym.huyc08.service.RequestNewMessage;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorUserNameExist;

import java.util.Scanner;

public class inputReceiverName implements HandlerNewMessage {
    private HandlerNewMessage next;
    private Scanner SCANNER = new Scanner(System.in);

    public inputReceiverName(HandlerNewMessage next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewMessage requestNewMessage) {
        System.out.println("Input receiver username");
        String username = SCANNER.nextLine();
        Validator validator = new ValidatorUserNameExist(username);
        if(validator.isCheck()) {
            requestNewMessage.setReceiverId(SingletonListNormalUser.getInstance().getCurrentUser(username).getUserId());
            System.out.println("Check username exist successfully");
            return true;
        } else {
            System.out.println("User does not exist in database");
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
