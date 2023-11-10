package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

public class ValidatorProductEnoughQuantity implements Validator{
    private int productId;
    private double productQuantity;

    public ValidatorProductEnoughQuantity(int productId, double productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean isCheck() {
        Product productToCheck = SingletonListProduct.getInstance().getProduct(productId);
        double productToCheckQuantity = productToCheck.getProductQuantity();
        return (productQuantity <= productToCheckQuantity);
    }
}
