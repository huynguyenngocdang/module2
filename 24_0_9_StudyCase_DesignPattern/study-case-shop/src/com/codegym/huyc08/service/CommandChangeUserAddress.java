package com.codegym.huyc08.service;

import java.util.Scanner;

public class CommandChangeUserAddress extends Subject implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        String currentUserAddress = SingletonCurrentUser.getInstance().getCurrentUser().getAddress();
        System.out.println("Your current Address is " + currentUserAddress);
        System.out.println("Input your new address");
        String newAddress = SCANNER.nextLine();
        Observer observer = SingletonCurrentUser.getInstance();
        addObserver(observer);
        SingletonCurrentUser.getInstance().changeUserAddress(newAddress);
        notifyObserver();
        removeObserver(observer);
    }
}
