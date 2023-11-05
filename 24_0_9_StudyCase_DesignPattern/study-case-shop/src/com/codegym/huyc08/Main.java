package com.codegym.huyc08;

import com.codegym.huyc08.menu.MenuLogin;
import com.codegym.huyc08.menu.Navigator;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new MenuLogin();
        navigator.navigate();
    }
}