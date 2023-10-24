package com.codegym.huy_c08.menu;

public class MenuMain {
    public void menuLogin() {
        System.out.println("""
                Menu Login
                1. Login
                2. Create new user
                99. See all user
                0. Exit""");
    }

    public void menuAdmin() {
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
                9. Manage promotion program
                0. Exit""");
    }
    public void menuPromotionManage(){
        System.out.println("""
                Promotion program
                1. See all promotion program
                2. Create new promotion program
                3. Change promotion program
                4. Remove promotion program
                0. Exit""");
    }
    public void menuPromotionChange() {
        System.out.println("""
                Change current promotion
                1. Change name
                2. Change start date
                3. Change end date
                4. Change promotion amount
                5. Change promotion percent
                0. Exit""");
    }

    public void menuUser() {
        System.out.println("""
                Main menu
                1. User profile
                2. Shop profile
                3. Shop
                0. Exit""");
    }

    public void menuUserProfile() {
        System.out.println("""
                User profile
                1. See user details
                2. Change user name
                3. Change user password
                4. Recharge wallet
                0. Exit""");
    }

    public void menuUserShopDetail() {
        System.out.println("""
                User shop detail
                1. See user cash
                2. See your current item
                3. Add new item
                4. Change your item
                5. Remove your item
                0. Exit""");
    }

    public void menuUserShopChangeProduct(){
        System.out.println("""
                Change product Menu
                1. Change product name
                2. Change product type
                3. Change product price
                4. Change product quantity
                5. Change product manufacturer
                6. Change product description
                0. Exit""");
    }
    public void menuUserShop() {
        System.out.println("""
                Shop menu
                1. Search for item
                2. Purchase item
                3. Check out
                0. Exit""");
    }

}
