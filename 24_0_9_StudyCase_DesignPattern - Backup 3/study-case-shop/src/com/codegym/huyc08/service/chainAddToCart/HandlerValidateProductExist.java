package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.ValidateProductExist;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorProductBelongToUser;

public class HandlerValidateProductExist implements HandlerAddToCart {
    private HandlerAddToCart next;

    public HandlerValidateProductExist(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        int productId = requestAddToCart.getProductId();
        Validator validator = new ValidateProductExist(productId);
        if(validator.isCheck()) {
            System.out.println("Check product exist successfully");
            return true;
        } else {
            System.out.println("There is no product with that id exist");
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
