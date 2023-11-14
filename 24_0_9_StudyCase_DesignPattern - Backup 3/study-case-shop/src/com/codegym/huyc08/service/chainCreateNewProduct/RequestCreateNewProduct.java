package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.service.RequestNewProduct;

public class RequestCreateNewProduct implements RequestNewProduct {
    private int productId;
    private int sellerId;
    private String productName;
    private String productType;
    private double productPrice;
    private double productQuantity;
    private String productManufacturer;
    private String productDescription;

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int getSellerId() {
        return sellerId;
    }

    @Override
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public double getProductQuantity() {
        return productQuantity;
    }

    @Override
    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String getProductManufacturer() {
        return productManufacturer;
    }

    @Override
    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    @Override
    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
