package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class ExitCommand implements Command {
    private String exitTitle;

    public ExitCommand(String exitTitle) {
        this.exitTitle = exitTitle;
    }

    @Override
    public void execute() {
        System.out.println("Exit " + exitTitle);
    }
}
