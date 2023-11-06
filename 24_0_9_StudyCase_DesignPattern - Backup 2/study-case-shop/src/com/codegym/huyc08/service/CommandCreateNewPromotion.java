package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;

import java.util.Scanner;

public class CommandCreateNewPromotion implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        GenerateId generateId = SingletonListPromotion.getInstance();
        int newId = generateId.getNewId();
        System.out.println("Input new promotion code");
        String newCode = SCANNER.next();
        System.out.println("Input new promotion start date");
        String newStartDate = SCANNER.next();
        System.out.println("Input new promotion end date");
        String newEndDate = SCANNER.next();
        System.out.println("Input new promotion amount");
        double newAmount = SCANNER.nextDouble();
        System.out.println("Input new promotion percent");
        double newPercent = SCANNER.nextDouble();
        //Validate promotion code - validate promotion end date - validate promotion amount - validate promotion percent
    }
}
