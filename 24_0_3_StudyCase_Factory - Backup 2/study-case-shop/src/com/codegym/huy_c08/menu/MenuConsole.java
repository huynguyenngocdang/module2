package com.codegym.huy_c08.menu;

import com.codegym.huy_c08.constants.Constants;

public class MenuConsole {
    public MenuConsole() {
    }
    public void printInvalidInput(){
        System.out.println("Invalid input, please try again");
        printHorizontalRule();
    }
    public void printInvalidInput(String reason){
        System.out.println("Invalid input "+reason+ ", please try again");
        printHorizontalRule();
    }
    public void printUserInput(String stringInput){
        System.out.println("Input your " + stringInput);
        printHorizontalRule();
    }
    public void printExitMenu(String stringExit) {
        System.out.println("Exit " + stringExit);
        printHorizontalRule();
    }
    public void printConfirm(String reason) {
        System.out.println("Do you want to " + reason + " (Y/N)");
        printHorizontalRule();
    }

    public void printCurrentUserInformationHeader(){

        printHorizontalRule();
        System.out.println("Current User information");
        printHorizontalRule();
    }
    public void printHorizontalRule(){
        System.out.println(Constants.HR);
    }
    public void printDoesNotChange(String reason) {
        System.out.println("You does not change " + reason);
    }
    public void printTypeDoesNotExist(String type){
        System.out.println("This "+type+ " does not exist in database");
    }

    public void printTypeAlreadyExist(String type){
        System.out.println("This "+ type + " already exist in database");
    }
    public void printUserInvalidName() {
        System.out.println("Username must have at least 3 character with no special characters");
    }

    public void printUserSimilarAdmin() {
        System.out.println("Cannot create new username start with admin_");
    }

    public void confirmNewProduct(int newProductSellerId, String newProductName, String newProductType, double newProductPrice, double newProductQuantity, String newProductManufacturer, String newProductDescription) {
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

    public void printCurrentProductHeader() {
        printHorizontalRule();
        System.out.println("Current product info");
        printHorizontalRule();
    }

    public void changeProductPrice(double priceChange, double currentlyHave) {
        System.out.printf("""
                You currently have %.2f
                Your wallet will be change by %.2f after change
                Your final wallet will be %.2f
                Do you wish to change? (Y/N)""", currentlyHave, -priceChange, currentlyHave - priceChange);;
    }
    public void notEnoughCash(String reason) {
        System.out.println("Not enough cash to " + reason);
    }
    public void confirmChange(String reason) {
        System.out.println("Do you wish to " + reason + "? (Y/N)");
    }
    public void promotionAlreadyEnd(){
        System.out.println("Promotion already end");
    }
    public void userAlreadyBanned(){
        System.out.println("You're banned from using this function");
    }

}
