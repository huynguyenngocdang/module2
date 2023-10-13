package com.codegym.shop.Menu;

public class Menu {
    public static void userLoginMenu() {
        System.out.println("""
                1. Login
                2. Create new user
                99. User List
                0. Exit""");
    }
    public static void userMenu() {
        System.out.println("""
                1. View user details
                2. Change user name
                3. Change user password
                4. Recharge wallet
                5. Search product
                6. Your product
                7. Create new product to sell
                8. Change product
                9. Buy product
                10. Remove product
                98. Set user permission (Admin only)
                99. User List
                0. Exit""");
    }


    public static void inputUsername(){
        System.out.println("Input your username");
    }
    public static void inputUsername(String input){
        System.out.println("Input " +input + " username");
    }

    public static void inputPassword() {
        System.out.println("Input your password");
    }
    public static void inputPassword(String input) {
        System.out.println("Input " +input + " password");
    }

    public static void inputInvalid() {
        System.out.println("Invalid Input");
    }

    public static void inputNewCash(){
        System.out.println("Input new amount");
    }

}
