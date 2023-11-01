package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class CreateNewUserCommand implements Command {
    private String commandName;

    public CreateNewUserCommand(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        System.out.println("Creating a new user");
    }
}
