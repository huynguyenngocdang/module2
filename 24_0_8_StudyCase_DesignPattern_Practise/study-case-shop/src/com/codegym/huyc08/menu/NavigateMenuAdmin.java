package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;

import java.util.Scanner;

public class NavigateMenuAdmin implements Navigator{
    private final Scanner SCANNER = new Scanner(System.in);
    private void navigateMenuAdmin() {
       int choice;
       do{
           System.out.println("""
                Admin menu
                1. Admin profile
                2. Admin command""");
           choice = SCANNER.nextInt();
       } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        navigateMenuAdmin();
    }
}
