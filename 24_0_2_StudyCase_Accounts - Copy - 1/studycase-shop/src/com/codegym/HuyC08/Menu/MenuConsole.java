package com.codegym.HuyC08.Menu;

public class MenuConsole {

    public static void inputUser(String type) {
        System.out.println("Input " + type);
    }

    public static void wrongPasswordEnter(int count) {
        System.out.println("Wrong password enter " + count + " times");
    }
    public static void wrongPasswordEnterFinal(int count) {
        System.out.println("You have enter wrong password " + count + " times \n This is the last attempt");
    }
    public static void noExistUserDatabase() {
        System.out.println("There is no exist user in database");
    }
    public static void existUserDatabase() {
        System.out.println("There is already exist user in database");
    }
    public static void loggingInSuccessful(){
        System.out.println("Logging in");
    }
    public static void exiting() {
        System.out.println("Exiting");
    }
    public static void invalidInput() {
        System.out.println("Invalid input");
    }
    public static void inputNewCash() {
        System.out.println("Recharge cash");
    }

    public static void currentUserData(String userDataType, String userData) {
        System.out.println("Your current " +userDataType+ " is: " + userData);
    }

    public static void currentUserData(String userDataType, double userData) {
        System.out.println("Your current " +userDataType+ " is: " + userData);
    }
    public static void notEnoughCash() {
        System.out.println("Not enough cash");
    }
    public static void notEnoughCash(String reason) {
        System.out.println("Not enough cash to " + reason);
    }

    public static void confirmNewProduct(int newProductSellerId, String newProductName, String newProductType, double newProductPrice, double newProductQuantity, String newProductManufacturer, String newProductDescription) {
        System.out.printf("""
                You are about to create
                Your current id = %d
                New product name = %s
                New product type = %s
                New product price = %.2f
                New product quantity = %.2f
                New product manufacture = %s
                New product description = %s
                """, newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
        System.out.println("Confirm Y/N");
    }
}
