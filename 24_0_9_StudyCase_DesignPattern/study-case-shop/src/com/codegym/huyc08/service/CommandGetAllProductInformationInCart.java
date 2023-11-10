package com.codegym.huyc08.service;

public class CommandGetAllProductInformationInCart implements Command{
    @Override
    public void execute() {
        SingletonShoppingCart.getInstance().displayCart();
    }
}
