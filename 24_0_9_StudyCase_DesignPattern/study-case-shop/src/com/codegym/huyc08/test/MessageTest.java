package com.codegym.huyc08.test;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Message;
import com.codegym.huyc08.entity.MessageFactory;
import com.codegym.huyc08.service.JsonFileHandler;
import com.codegym.huyc08.service.MyFileHandler;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MessageTest {
    public static void main(String[] args) {
        List<Message> messages = new ArrayList<>();
        MessageFactory factory = new MessageFactory();
        messages.add(factory.createMessage(1, -1, "abc"));
        MyFileHandler fileHandler = new JsonFileHandler();
        fileHandler.saveToFile(Constants.MESSAGE_FILE_PATH, messages);

        Type messageType = new TypeToken<ArrayList<Message>>(){}.getType();
        List<Message> messageList = (List<Message>) fileHandler.readFromFile(Constants.MESSAGE_FILE_PATH, messageType);
        for (Message message: messageList
             ) {
            System.out.println(message.toString());
        }
    }
}
