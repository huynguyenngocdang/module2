package com.codegym.huyc08.service;

public class CommandGetCurrentUserProductInformation implements Command{
    @Override
    public void execute() {
        System.out.println("Your current product information: ");
        System.out.println(SingletonCurrentUserProduct.getInstance().getCurrentUserProduct().toString());
    }
}
