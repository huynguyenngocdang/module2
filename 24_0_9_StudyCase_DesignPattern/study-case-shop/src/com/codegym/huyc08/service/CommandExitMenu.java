package com.codegym.huyc08.service;

public class CommandExitMenu implements Command {
    private String title;

    public CommandExitMenu(String title) {
        this.title = title;
    }

    @Override
    public void execute() {
        System.out.println("Exiting " + title);
    }
}
