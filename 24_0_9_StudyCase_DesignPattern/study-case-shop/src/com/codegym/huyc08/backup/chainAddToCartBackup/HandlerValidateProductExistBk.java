package com.codegym.huyc08.backup.chainAddToCartBackup;

import com.codegym.huyc08.service.ValidateProductExist;
import com.codegym.huyc08.service.Validator;

public class HandlerValidateProductExistBk implements HandlerAddToCartBk {
    private HandlerAddToCartBk next;

    public HandlerValidateProductExistBk(HandlerAddToCartBk next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCartBk requestAddToCartBk) {
        int productId = requestAddToCartBk.getProductId();
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
    public void handle(RequestAddToCartBk requestAddToCartBk) {
        if(!doHandle(requestAddToCartBk)) {
            return;
        }
        if(next != null) {
            next.handle(requestAddToCartBk);
        }
    }
}
