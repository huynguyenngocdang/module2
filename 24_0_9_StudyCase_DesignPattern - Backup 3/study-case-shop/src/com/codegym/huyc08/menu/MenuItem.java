package com.codegym.huyc08.menu;

import com.codegym.huyc08.service.Command;

public class MenuItem {
    private String name;
    private Command command;

    public MenuItem(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
