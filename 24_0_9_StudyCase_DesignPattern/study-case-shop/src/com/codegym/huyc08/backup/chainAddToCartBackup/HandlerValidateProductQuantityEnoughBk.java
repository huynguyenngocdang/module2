package com.codegym.huyc08.backup.chainAddToCartBackup;

import com.codegym.huyc08.service.SingletonShoppingCart;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorProductEnoughQuantity;

public class HandlerValidateProductQuantityEnoughBk implements HandlerAddToCartBk {
    private HandlerAddToCartBk next;

    public HandlerValidateProductQuantityEnoughBk(HandlerAddToCartBk next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCartBk requestAddToCartBk) {
        try {
            double currentCartItemQuantity = SingletonShoppingCart.getInstance().getCartItem(requestAddToCartBk.getProductId()).getQuantity();
            double currentRequest = currentCartItemQuantity + requestAddToCartBk.getProductQuantity();
            Validator validator = new ValidatorProductEnoughQuantity(requestAddToCartBk.getProductId(), currentRequest);
            if(validator.isCheck()) {
                System.out.println("Check product has enough quantity successfully");
                return true;
            } else {
                System.out.println("Product does not have enough quantity");
                return false;
            }

        } catch (NullPointerException e) {
            Validator validator = new ValidatorProductEnoughQuantity(requestAddToCartBk.getProductId(), requestAddToCartBk.getProductQuantity());
            if(validator.isCheck()) {
                System.out.println("Check product has enough quantity successfully");
                return true;
            } else {
                System.out.println("Product does not have enough quantity");
                return false;
            }
        }

    }

    @Override
    public void handle(RequestAddToCartBk requestAddToCartBk) {
        if(!doHandle(requestAddToCartBk)) {
            return;
        }
        if(next != null) {
            next.handle(requestAddToCartBk);
        }
    }
}
