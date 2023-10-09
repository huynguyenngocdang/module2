package com.codegym;



public class Menu {

    public static void printMenu () {
        System.out.println("""
                1. Convert decimal to binary
                2. Convert binary to decimal
                3. Convert decimal to hexadecimal
                4. Convert hexadecimal to decimal
                0. Exit""");
    }

    public static void printInputDecimal() {
        System.out.println("Input decimal");
    }

    public static void printInputBinary() {
        System.out.println("Input binary");
    }
    public static void printInputHexadecimal() {
        System.out.println("Input hexadecimal");
    }
    public static void printExit(){
        System.out.println("Exiting");
    }

    public static void printBinary() {
        System.out.print("\nBinary equivalent = ");
    }

    public static void printDecimal() {
        System.out.print("\nDecimal equivalent = ");
    }

    public static void printHexadecimal() {
        System.out.print("\nHexadecimal equivalent = ");
    }

    public static void printInputInvalid() {
        System.out.println("Input invalid \n");
    }
}
