package com.codegym.HuyC08.Menu;

import java.util.Scanner;

public class Navigation {
    private static final Scanner scanner = new Scanner(System.in);
    public static void navigationLogin() {
        int choice = -1;
        while (choice!= 0) {
            MenuMain.menuLogin();
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    }

    public static void navigationUserMenu() {
        int choice = -1;
        while (choice!= 0) {

        }
    }
}
