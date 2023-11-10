package com.codegym.huy_c08.menu;

public class MenuMain {
    public void showMenuLogin() {
        System.out.println("""
                Menu Login
                1. Login
                2. Create new user
                3. Forgot password
                99. See all user
                0. Exit""");
    }

    public void showMenuAdmin() {
        System.out.println("""
                Admin menu
                1. User profile
                2. Show all user
                3. Check user status
                4. search user by name
                4. Change user name
                5. Change user password 
                6. Banned/unbanned user
                7. Delete user (soft delete) -> isDelete = t/f
                8. Create new admin (superAdmin / admin)
                9. Manage promotion program
                0. Exit""");
    }
    public void showMenuPromotionProgram(){
        System.out.println("""
                Promotion program
                1. See all promotion program
                2. Create new promotion program
                3. Change promotion program
                4. Remove promotion program
                5. Remove all expired promotion program
                0. Exit""");
    }
    public void showMenuPromotionChange() {
        System.out.println("""
                Change current promotion
                1. Change name
                2. Change start date
                3. Change end date
                4. Change promotion amount
                5. Change promotion percent
                0. Exit""");
    }

    public void showMenuUser() {
        System.out.println("""
                Main menu
                1. User profile
                2. Shop profile
                3. Shop
                0. Exit""");
    }

    public void showMenuUserProfile() {
        System.out.println("""
                User profile
                1. See user details
                2. Change user name
                3. Change user password
                4. Recharge wallet
                0. Exit""");
    }

    public void showMenuUserShopDetail() {
        System.out.println("""
                User shop detail
                1. See user cash
                2. See your current product
                3. Add new product
                4. Change your product
                5. Remove your product
                0. Exit""");
    }

    public void showMenuUserShopChangeProduct(){
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
    public void showMenuUserShop() {
        System.out.println("""
                Shop menu
                1. Search for item
                2. Add to cart
                3. Check out
                0. Exit""");
    }
    public void showMenuCart(){
        System.out.println("""
                Cart menu
                1. Show your cart items
                2. Remove your cart
                3. Remove item in cart
                3. Check out
                0. Exit""");
    }

}
