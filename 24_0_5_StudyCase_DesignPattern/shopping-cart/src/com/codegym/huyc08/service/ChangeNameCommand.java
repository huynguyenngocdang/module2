package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class ChangeNameCommand implements Command {
    private String commandName;

    public ChangeNameCommand(String commandName) {
        this.commandName = commandName;
    }


    @Override
    public void execute() {
        System.out.println("Change user name");
    }

    @Override
    public String getCommandName() {
        return this.commandName;
    }
}
