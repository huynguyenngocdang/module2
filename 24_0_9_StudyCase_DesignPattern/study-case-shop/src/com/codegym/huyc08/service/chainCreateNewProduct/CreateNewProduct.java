package com.codegym.huyc08.service.chainCreateNewProduct;

import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.entity.ProductFactory;
import com.codegym.huyc08.service.GenerateId;
import com.codegym.huyc08.service.HandlerNewProduct;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestNewProduct;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.Subject;

import java.util.Scanner;

public class CreateNewProduct extends Subject implements HandlerNewProduct {
    private HandlerNewProduct next;


    public CreateNewProduct(HandlerNewProduct next) {
        this.next = next;

    }

    @Override
    public boolean doHandle(RequestNewProduct requestNewProduct) {
        try {
            Product newProduct = createNewProduct(requestNewProduct);
            updateNewProduct(newProduct);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Can't create new product");
            System.out.println(e.getMessage());
            return true;
        }

    }

    private Product createNewProduct(RequestNewProduct requestNewProduct) {
        GenerateId generateId = SingletonListProduct.getInstance();
        int newProductId = generateId.getNewId();
        int newProductSellerId = SingletonCurrentUser.getInstance().getCurrentUser().getUserId();
        String newProductName = requestNewProduct.getProductName();
        String newProductType = requestNewProduct.getProductType();
        double newProductPrice = requestNewProduct.getProductPrice();
        double newProductQuantity = requestNewProduct.getProductQuantity();
        String newProductManufacturer = requestNewProduct.getProductManufacturer();
        String newProductDescription = requestNewProduct.getProductDescription();
        ProductFactory factory = new ProductFactory();
        Product newProduct = factory.createProduct(newProductId, newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
        return newProduct;
    }

    private void updateNewProduct(Product newProduct) {
        Observer observer = SingletonListProduct.getInstance();
        addObserver(observer);
        SingletonListProduct.getInstance().getProducts().add(newProduct);
        notifyObserver();
        removeObserver(observer);
    }

    @Override
    public void handle(RequestNewProduct requestNewProduct) {
        if(!doHandle(requestNewProduct)) {
            return;
        }
        if(next != null) {
            next.handle(requestNewProduct);
        }
    }
}
