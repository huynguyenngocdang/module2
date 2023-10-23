package com.codegym.huyc08.menu;

public class MenuMain {
     void MenuLogin() {
        System.out.println("""
                Menu Login
                1. Login
                2. Create new user
                99. See all user
                0. Exit""");
    }
     void MenuUser(){
        System.out.println("""
                Main menu
                1. User profile
                2. Shop profile
                3. Shop
                0. Exit""");
    }
     void MenuAdmin(){
        System.out.println("""
                Admin menu
                1. User profile
                2. Show all user
                3. Check user status
                4. Change user name
                5. Change user password
                6. Banned/unbanned user
                7. Delete user
                8. Create new admin
                0. Exit""");
    }
}
