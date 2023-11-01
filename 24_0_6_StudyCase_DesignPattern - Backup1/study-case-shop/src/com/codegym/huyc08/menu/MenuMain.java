package com.codegym.huyc08.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuMain implements Menu {
    private List<MenuItem> menuItems;
    public MenuMain() {
        this.menuItems = new ArrayList<>();
    }

    @Override
    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void displayMenu() {
        System.out.println("Login menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i) + ". " + menuItems.get(i).getName());
        }
    }

    @Override
    public void executeMenuItem(int index) {
        if (index > 0 && index < menuItems.size()) {
            menuItems.get(index).getCommand().execute();
        } else if(index == 0) {
            System.out.println("Exiting...");
        } else  {
            System.out.println("Invalid menu item!");
        }
    }
}
