package com.codegym;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu.printMenu();
        int choice = scanner.nextInt();
        do {
        switch (choice) {
            case 1:
                Menu.printInputDecimal();
                Converter.convertDecimalToBinary(scanner.nextInt());
                break;
            case 2:
                Menu.printInputBinary();
                Converter.convertBinaryToDecimal(scanner.nextLong());
                break;
            case 3:
                Menu.printInputDecimal();
                Converter.convertDecimalToHex(scanner.nextInt());
                break;
            case 4:
                Menu.printInputHexadecimal();
                Converter.convertHexToDecimal(scanner.next());
                break;
            case 0:
                Menu.printExit();
                return;
            default:
                Menu.printInputInvalid();
                break;

        }
        Menu.printMenu();
        choice = scanner.nextInt();
            if (choice == 0) {
                Menu.printExit();
            }
        } while (choice != 0);
    }
}