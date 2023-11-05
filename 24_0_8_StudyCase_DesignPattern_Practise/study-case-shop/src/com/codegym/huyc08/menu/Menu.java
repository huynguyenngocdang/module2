package com.codegym.huyc08.menu;

public interface Menu {
    void addMenuItem(MenuItem menuItem);
    void display();
    void runCommand(int index);
}
