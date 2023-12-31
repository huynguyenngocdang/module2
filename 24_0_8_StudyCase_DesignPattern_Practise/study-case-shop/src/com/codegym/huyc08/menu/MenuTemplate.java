package com.codegym.huyc08.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuTemplate implements Menu{
    List<MenuItem> menuItems;

    public MenuTemplate() {
        this.menuItems = new ArrayList<>();
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void display() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + ". " + menuItems.get(i).getName());
        }
    }

    @Override
    public void runCommand(int index) {
        if(index >= 0 && index < menuItems.size()) {
            menuItems.get(index).getCommand().execute();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }
}
