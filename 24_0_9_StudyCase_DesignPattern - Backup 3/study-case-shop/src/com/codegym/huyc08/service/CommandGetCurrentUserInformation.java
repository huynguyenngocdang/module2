package com.codegym.huyc08.service;

public class CommandGetCurrentUserInformation implements Command {
    @Override
    public void execute() {
        System.out.println(SingletonCurrentUser.getInstance().getCurrentUser().toString());
    }
}
