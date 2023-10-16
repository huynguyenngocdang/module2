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
                4. Recharge wallet
                0. Exit""");
    }
    public static void menuUserShopDetail() {
        System.out.println("""
                1. See user cash
                2. See your current item
                3. Add new item
                4. Change your item
                5. Remove your item
                0. Exit""");
    }

    public static void menuUserShop() {
        System.out.println("""
                1. Search for item
                2. Purchase item
                3. Check out
                0. Exit""");
    }
}
