package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.service.HandlerNewProduct;
import com.codegym.huyc08.service.RequestNewProduct;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDoubleNotNegative;

public class ValidateNewProductPriceNotNegative implements HandlerNewProduct {
    private HandlerNewProduct next;


    public ValidateNewProductPriceNotNegative(HandlerNewProduct next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewProduct requestNewProduct) {
        Validator validator = new ValidatorDoubleNotNegative(requestNewProduct.getProductPrice());
        if (validator.isCheck()) {
            System.out.println("Check product price not negative successfully");
            return true;
        } else {
            System.out.println("Product price can't be negative, please try again");
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
