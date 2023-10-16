package com.codegym.HuyC08.Menu;

public class MenuMain {
    public static void menuLogin() {
        System.out.println("""
                1. Login
                2. Create new user
                99. See user list
                0. Exit""");
    }
    public static void menuUser() {
        System.out.println("""
                1. User profile
                2. Shop profile
                3. Shop
                0. Exit""");
    }

    public static void menuUserDetail() {
        System.out.println("""
                1. See user details
                2. Change user name
                3. Change user password
                0. Exit""");
    }
}
