package com.codegym.huyc08.entity;

import com.codegym.huyc08.constant.AppConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PurchaseOrder {
    private int purchaseOrderId;
    private int customerId;
    private int sellerId;
    private int productId;
    private String orderDate;
    private double price;
    private double quantity;
    private double totalCost;
    private double totalCostAfterPromotion;
    private String promotionCode = "none";
    private double promotionAmount = 0;
    private double promotionPercent = 0;

    public PurchaseOrder(int purchaseOrderId, int customerId, int sellerId, int productId, double price, double quantity, double totalCost) {
        this.purchaseOrderId = purchaseOrderId;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.totalCost = totalCost;
        LocalDateTime orderDateNow = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.FULL_DATE_PATTERN_REGEX);
        this.orderDate = orderDateNow.format(dateTimeFormatter);
        this.totalCostAfterPromotion = this.totalCost;
    }

    public PurchaseOrder(int purchaseOrderId, int customerId, int sellerId, int productId, double price, double quantity, double totalCost, double totalCostAfterPromotion, String promotionCode, double promotionAmount, double promotionPercent) {
        this.purchaseOrderId = purchaseOrderId;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.totalCost = totalCost;
        LocalDateTime orderDateNow = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.FULL_DATE_PATTERN_REGEX);
        this.orderDate = orderDateNow.format(dateTimeFormatter);
        this.totalCostAfterPromotion = totalCostAfterPromotion;
        this.promotionCode = promotionCode;
        this.promotionAmount = promotionAmount;
        this.promotionPercent = promotionPercent;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalCostAfterPromotion() {
        return totalCostAfterPromotion;
    }

    public void setTotalCostAfterPromotion(double totalCostAfterPromotion) {
        this.totalCostAfterPromotion = totalCostAfterPromotion;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public double getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(double promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public double getPromotionPercent() {
        return promotionPercent;
    }

    public void setPromotionPercent(double promotionPercent) {
        this.promotionPercent = promotionPercent;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", customerId=" + customerId +
                ", sellerId=" + sellerId +
                ", productId=" + productId +
                ", orderDate='" + orderDate + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalCost=" + totalCost +
                ", totalCostAfterPromotion=" + totalCostAfterPromotion +
                ", promotionCode='" + promotionCode + '\'' +
                ", promotionAmount=" + promotionAmount +
                ", promotionPercent=" + promotionPercent +
                '}';
    }
}
