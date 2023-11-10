package com.codegym.huyc08.service;

public class CommandRemoveAllCartLine implements Command{
    @Override
    public void execute() {
        Confirm confirm = new Confirmation("remove all cart line");
        if(confirm.isConfirm()) {
            SingletonShoppingCart.getInstance().emptyCart();
        }
    }
}
