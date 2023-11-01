package com.codegym.huyc08.menu;

import java.util.ArrayList;
import java.util.List;

public  class Menu {
    private List<Command> commands;

    public Menu(){
        commands = new ArrayList<>();
    }
    public void addCommand(Command command) {
        commands.add(command);
    }
    public void displayMenu() {
        System.out.println("Menu: ");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i+1) + ". " + commands.get(i).getCommandName());
        }
        System.out.println("0. Exit");
    }
    public void executeCommand(int choice) {
        if (choice > 0 && choice <= commands.size()) {
            commands.get(choice - 1).execute();
        } else if (choice == 0) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
