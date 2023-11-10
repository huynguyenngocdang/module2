package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.ValidateProductExist;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorProductBelongToUser;
import com.codegym.huyc08.service.ValidatorProductEnoughQuantity;

public class HandlerValidateProductQuantityEnough implements HandlerAddToCart {
    private HandlerAddToCart next;

    public HandlerValidateProductQuantityEnough(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        Validator validator = new ValidatorProductEnoughQuantity(requestAddToCart.getProductId(), requestAddToCart.getProductQuantity());
        if(validator.isCheck()) {
            System.out.println("Check product has enough quantity successfully");
            return true;
        } else {
            System.out.println("Product does not have enough quantity");
            return false;
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
