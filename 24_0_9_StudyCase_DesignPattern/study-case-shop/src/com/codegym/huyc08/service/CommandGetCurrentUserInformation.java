package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class CommandGetCurrentUserInformation implements Command {
    @Override
    public void execute() {
        System.out.println(SingletonCurrentUser.getInstance().getCurrentUser().toString());
    }
}
