package com.codegym.HuyC08.Entity;

public class Product {
    private int productId;
    private int sellerId;
    private String productName;
    private String productType;
    private double productPrice;
    private double productQuantity;
    private String productManufacturer;
    private String productDescription;

    public Product(int productId, int sellerId, String productName, String productType, double productPrice, double productQuantity, String productManufacturer) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productManufacturer = productManufacturer;
        this.productDescription = "A " + productType + " manufactured by " + productManufacturer;
    }

    public Product(int productId, int sellerId, String productName, String productType, double productPrice, double productQuantity, String productManufacturer, String productDescription) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productManufacturer = productManufacturer;
        this.productDescription = productDescription;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", sellerId=" + sellerId +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productManufacturer='" + productManufacturer + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
