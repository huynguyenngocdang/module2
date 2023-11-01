package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class ChangePasswordCommand implements Command {
    private String commandName;

    public ChangePasswordCommand(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public void execute() {
        System.out.println("Change password");
    }

    @Override
    public String getCommandName() {
        return this.commandName;
    }
}
