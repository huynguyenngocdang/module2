package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class CommandExit implements Command {
    private String title;

    public CommandExit(String title) {
        this.title = title;
    }

    @Override
    public void execute() {
        System.out.println("Exit " + title);
    }
}
