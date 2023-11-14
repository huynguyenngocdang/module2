package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Message;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonListMessage implements Observer {
    private List<Message> messages;
    private MyFileHandler fileHandler;
    private Type MESSAGE_TYPE = new TypeToken<ArrayList<Message>>(){}.getType();
    private static SingletonListMessage instance;
    private SingletonListMessage(){
        this.fileHandler  = new JsonFileHandler();
        this.messages = (List<Message>) fileHandler.readFromFile(Constants.MESSAGE_FILE_PATH, MESSAGE_TYPE);
        if(messages == null) {
            messages = new ArrayList<>();
        }
    }
    public static SingletonListMessage getInstance(){
        if(instance == null) {
            instance = new SingletonListMessage();
        }
        return instance;
    }

    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public void update() {
        fileHandler.saveToFile(Constants.MESSAGE_FILE_PATH, messages);
        System.out.println("Message updated successfully");
    }
}
