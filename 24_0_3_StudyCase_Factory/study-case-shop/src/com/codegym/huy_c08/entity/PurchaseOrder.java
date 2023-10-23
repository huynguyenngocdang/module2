package com.codegym.huy_c08.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PurchaseOrder {
    private int orderId;
    private int customerId;
    private int sellerId;
    private int productId;

    private double price;
    private double quantity;
    private double totalCost;
    private String orderDate;

    public PurchaseOrder(int orderId, int customerId, int sellerId, int productId, double price, double quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.totalCost = price * quantity;
        LocalDateTime orderDateNow = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy,HH:mm:ss");
        this.orderDate = orderDateNow.format(dateTimeFormatter);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", sellerId=" + sellerId +
                ", productId=" + productId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalCost=" + totalCost +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
