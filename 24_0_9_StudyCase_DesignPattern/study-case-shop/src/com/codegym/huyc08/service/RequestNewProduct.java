package com.codegym.huyc08.service;

public interface RequestNewProduct {
    int getProductId();

    void setProductId(int productId);

    int getSellerId();

    void setSellerId(int sellerId);

    String getProductName();

    void setProductName(String productName);

    String getProductType();

    void setProductType(String productType);

    double getProductPrice();

    void setProductPrice(double productPrice);

    double getProductQuantity();

    void setProductQuantity(double productQuantity);

    String getProductManufacturer();

    void setProductManufacturer(String productManufacturer);

    String getProductDescription();

    void setProductDescription(String productDescription);
}
