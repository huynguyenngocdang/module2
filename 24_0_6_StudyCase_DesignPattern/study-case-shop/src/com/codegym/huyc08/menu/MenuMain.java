package com.codegym.huyc08.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuMain implements Menu {
    private List<MenuItem> menuItems;
    private String title;
    public MenuMain(String title) {
        this.menuItems = new ArrayList<>();
        this.title = title;
    }

    @Override
    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void displayMenu() {
        System.out.println("Menu " + this.title + ":");
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
