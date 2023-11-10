package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.RequestAddToCart;

public class RequestToAddToCart implements RequestAddToCart {
    private int productId;

    private double productQuantity;

    public RequestToAddToCart() {

    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public double getProductQuantity() {
        return productQuantity;
    }

    @Override
    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }
}
