package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import jdk.jfr.Name;

public class LoginCommand implements Command {
    private String commandName;
    private boolean isLoginSuccess;

    public LoginCommand(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        System.out.println("Logging in");
    }
}
