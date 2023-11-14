package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.service.HandlerNewProduct;
import com.codegym.huyc08.service.RequestNewProduct;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDoubleNotNegative;

public class ValidateNewProductQuantityNotNegative implements HandlerNewProduct {
    private HandlerNewProduct next;


    public ValidateNewProductQuantityNotNegative(HandlerNewProduct next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewProduct requestNewProduct) {
        Validator validator = new ValidatorDoubleNotNegative(requestNewProduct.getProductQuantity());
        if (validator.isCheck()) {
            System.out.println("Check product quantity not negative successfully");
            return true;
        } else {
            System.out.println("Product quantity can't be negative, please try again");
            return false;
        }
    }

    @Override
    public void handle(RequestNewProduct requestNewProduct) {
        if(!doHandle(requestNewProduct)) {
            return;
        }
        if(next != null) {
            next.handle(requestNewProduct);
        }
    }
}
