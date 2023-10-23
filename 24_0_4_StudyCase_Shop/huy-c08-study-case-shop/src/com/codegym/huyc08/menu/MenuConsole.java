package com.codegym.huyc08.menu;

public class MenuConsole {
    public MenuConsole() {
    }
    void invalidInput(String reason) {
        System.out.println("Invalid input " + reason + ", Please try again");
    }

    public void printUserInput(String stringInput){
        System.out.println("Input your " + stringInput);
    }
}
