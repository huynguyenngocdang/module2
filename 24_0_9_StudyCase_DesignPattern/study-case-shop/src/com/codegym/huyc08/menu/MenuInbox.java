package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandCreateNewMessage;
import com.codegym.huyc08.service.CommandExit;
import com.codegym.huyc08.service.CommandRemoveMessage;
import com.codegym.huyc08.service.CommandViewInbox;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInbox implements Navigator, Command {

    private int userId;

    public MenuInbox(int userId) {
        this.userId = userId;
    }

    private void displayInbox(){
        Scanner SCANNER = new Scanner(System.in);
        Menu menuInbox = new MenuTemplate("Inbox");
        menuInbox.addMenuItem(new MenuItem("Exit", new CommandExit("Inbox")));
        menuInbox.addMenuItem(new MenuItem("View inbox", new CommandViewInbox()));
        menuInbox.addMenuItem(new MenuItem("Remove message line", new CommandRemoveMessage()));
        menuInbox.addMenuItem(new MenuItem("Create new message", new CommandCreateNewMessage(userId)));
        int choice;
        try {
            do {
                menuInbox.display();
                choice = SCANNER.nextInt();
                menuInbox.runCommand(choice);
            } while (choice != AppConstant.USER_EXIT_CHOICE);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            displayInbox();
        }

    }
    @Override
    public void navigate() {
        displayInbox();
    }

    @Override
    public void execute() {
        navigate();
    }
}
