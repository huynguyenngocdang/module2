package com.codegym.huyc08.menu;

import com.codegym.huyc08.constant.Constants;

import java.util.Scanner;

public class NavigateMenuUser implements Navigator{
    private final Scanner SCANNER = new Scanner(System.in);
    private void navigateMenuUser() {

        int choice;
        do{
            System.out.println("""
                UserProfile
                1. User profile
                2. User Shop
                3. Shop""");
            choice = SCANNER.nextInt();
        } while (choice != Constants.USER_EXIT_CHOICE);
    }
    @Override
    public void navigate() {
        navigateMenuUser();
    }
}
