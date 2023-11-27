package com.codegym.huyc08.backup.chainAddToCartBackup;

import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorProductBelongToUser;

public class HandlerValidateProductIdBelongToUserBk implements HandlerAddToCartBk {
    private HandlerAddToCartBk next;

    public HandlerValidateProductIdBelongToUserBk(HandlerAddToCartBk next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCartBk requestAddToCartBk) {
        int productId = requestAddToCartBk.getProductId();
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
    public void handle(RequestAddToCartBk requestAddToCartBk) {
        if(!doHandle(requestAddToCartBk)) {
            return;
        }
        if(next != null) {
            next.handle(requestAddToCartBk);
        }
    }
}
