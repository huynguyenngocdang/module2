package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandCreateNewUser implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input your new username");
        String username = SCANNER.next();
        System.out.println("Input your new password");
        String password = SCANNER.next();
    }
}
