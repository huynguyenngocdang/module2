package com.codegym.huyc08.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuTemplate implements Menu {
    private String title;
    private List<MenuItem> menuItems;

    public MenuTemplate(String title) {
        this.title = title;
        this.menuItems = new ArrayList<>();
    }
    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
    @Override
    public void display(){
        System.out.println(title);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + ". " + menuItems.get(i).getName());
        }
        System.out.println("Enter your choice");
    }
    @Override
    public void runCommand(int choice) {
        if(choice >= 0 && choice < menuItems.size()) {
            menuItems.get(choice).getCommand().execute();
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }
}
