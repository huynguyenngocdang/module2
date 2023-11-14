package com.codegym.huyc08.service;

public class CommandViewInbox implements Command{
    @Override
    public void execute() {
        SingletonCurrentUserListMessage.getInstance().displayMessage();
    }
}
