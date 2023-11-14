package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorProductBelongToUser;

import java.util.Scanner;

public class HandlerValidateProductIdBelongToUser implements HandlerAddToCart {
    private HandlerAddToCart next;

    public HandlerValidateProductIdBelongToUser(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        int productId = requestAddToCart.getProductId();
        int buyerId = SingletonCurrentUser.getInstance().getCurrentUser().getUserId();
        Validator validator = new ValidatorProductBelongToUser(productId, buyerId);
        if(validator.isCheck()) {
            System.out.println("You can't buy your own product");
            return false;
        } else {
            System.out.println("Check product not belong to user successfully");
            return true;
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
