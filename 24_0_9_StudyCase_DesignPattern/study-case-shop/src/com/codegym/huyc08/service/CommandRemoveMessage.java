package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Message;
import com.codegym.huyc08.menu.MenuAdmin;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommandRemoveMessage extends Subject implements Command{

    private Scanner SCANNER;

    @Override
    public void execute() {
        try {
            SCANNER = new Scanner(System.in);
            Command displayInbox = new CommandViewInbox();
            displayInbox.execute();
            System.out.println("Input message line you want to remove");
            int choice = SCANNER.nextInt() - 1;
            Observer observer = SingletonListMessage.getInstance();
            addObserver(observer);
            SingletonCurrentUserListMessage.getInstance().removeMessage(choice);
            notifyObserver();
            removeObserver(observer);
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Invalid choice, please try again");
        }
    }
}
