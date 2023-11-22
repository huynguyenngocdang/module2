package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonShoppingCart;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorProductEnoughQuantity;

public class HandlerValidateProductEnoughQuantity implements HandlerAddToCart {
    private HandlerAddToCart next;

    public HandlerValidateProductEnoughQuantity(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        try {
            double currentCartItemQuantity = SingletonShoppingCart.getInstance().getCartItem(requestAddToCart.getProduct().getProductId()).getQuantity();
            double currentRequest = currentCartItemQuantity + requestAddToCart.getQuantity();
            Validator validator = new ValidatorProductEnoughQuantity(requestAddToCart.getProduct().getProductId(), currentRequest);
            if(validator.isCheck()) {
                System.out.println("Check product has enough quantity successfully");
                return true;
            } else {
                System.out.println("Product does not have enough quantity");
                return false;
            }

        } catch (NullPointerException e) {
            Validator validator = new ValidatorProductEnoughQuantity(requestAddToCart.getProduct().getProductId(), requestAddToCart.getQuantity());
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
    public void handle(RequestAddToCart requestAddToCart) {
        if(!doHandle(requestAddToCart)) {
            return;
        }
        if(next != null) {
            next.handle(requestAddToCart);
        }
    }
}
