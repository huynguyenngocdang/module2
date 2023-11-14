package com.codegym.huyc08.service;

public class CommandExit implements Command {
    private String title;

    public CommandExit(String title) {
        this.title = title;
    }

    @Override
    public void execute() {
        System.out.println("Exiting " + title);
    }
}
