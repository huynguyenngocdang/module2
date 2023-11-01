package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

public class ExitCommand implements Command {
    private String exitState;

    public ExitCommand(String exitState) {
        this.exitState = exitState;
    }

    @Override
    public void execute() {
        System.out.println("Exit " + this.exitState );
    }
}
