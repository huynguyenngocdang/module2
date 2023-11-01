package com.codegym.huyc08.menu;

public interface Menu {
    void addItem(MenuItem menuItem);
    void displayMenu();
    void executeMenuItem(int index);
}
