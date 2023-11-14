package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class SingletonCurrentUserListMessage {
    private List<Message> currentUserMessage;
    private static SingletonCurrentUserListMessage instance;
    private SingletonCurrentUserListMessage(){
        currentUserMessage = new ArrayList<>();
    }
    public static SingletonCurrentUserListMessage getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentUserListMessage();
        }
        return instance;
    }

    public List<Message> getCurrentUserMessage() {
        return currentUserMessage;
    }

    public void setCurrentUserMessage(int userId) {
        try {
            currentUserMessage.clear();
            for (Message message: SingletonListMessage.getInstance().getMessages()
            ) {
                if(message.getReceiverId() == userId) {
                    currentUserMessage.add(message);
                }
            }

        } catch (NullPointerException e) {
            for (Message message: SingletonListMessage.getInstance().getMessages()
            ) {

                if(message.getReceiverId() == userId) {
                    currentUserMessage.add(message);
                }
            }
        }

    }
    public void displayMessage() {
        if(currentUserMessage.isEmpty()){
            System.out.println("Your inbox is empty");
        } else {
            for (int i = 0; i < currentUserMessage.size(); i++) {
                System.out.println((i+1) + ". " + currentUserMessage.get(i).toString());
            }
        }
    }
    public void removeMessage(int choice) {
        Message thisRemoveMessage = currentUserMessage.remove(choice);
        SingletonListMessage.getInstance().getMessages().remove(thisRemoveMessage);
    }
}
