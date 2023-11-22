package com.codegym.huyc08.backup.chainAddToCartBackup;

public class RequestToAddToCartBk implements RequestAddToCartBk {
    private int productId;

    private double productQuantity;

    public RequestToAddToCartBk() {

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
