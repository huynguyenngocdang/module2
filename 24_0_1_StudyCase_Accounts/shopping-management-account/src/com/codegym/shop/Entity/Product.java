package com.codegym.shop.Entity;

public class Product {
    private String name;
    private String type;
    private String producer;
    private int price;
    private int amount;

    private String seller;

    public Product() {
    }

    public Product(String name, String type, String producer, int price, int amount) {
        this.name = name;
        this.type = type;
        this.producer = producer;
        this.price = price;
        this.amount = amount;
        this.seller = "Anonymous";
    }

    public Product(String name, String type, String producer, int price, int amount, String seller) {
        this.name = name;
        this.type = type;
        this.producer = producer;
        this.price = price;
        this.amount = amount;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", seller='" + seller + '\'' +
                '}';
    }
}
