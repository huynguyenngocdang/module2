package com.codegym.huyc08.service;

public class CommandAddToCart implements Command{

    @Override
    public void execute() {
        Command commandSearchProduct = new CommandSearchProduct();
        commandSearchProduct.execute();
    }
}
