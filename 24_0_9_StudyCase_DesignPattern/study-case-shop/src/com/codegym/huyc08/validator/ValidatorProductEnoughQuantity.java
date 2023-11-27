package com.codegym.huyc08.validator;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.SingletonListProduct;

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
