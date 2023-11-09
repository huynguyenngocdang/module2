package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonListProduct implements GenerateId, Observer {
    private List<Product> products;
    private final MyFileHandler fileHandler;
    private final Type PRODUCTTYPE = new TypeToken<ArrayList<Product>>(){}.getType();
    private static SingletonListProduct instance;
    private SingletonListProduct() {
        fileHandler = new JsonFileHandler();
        products = (ArrayList<Product>) fileHandler.readFromFile(Constants.PRODUCT_FILE_PATH, PRODUCTTYPE);
    }
    public static SingletonListProduct getInstance() {
        if(instance == null) {
            instance = new SingletonListProduct();
        }
        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public int getNewId() {
        int max = 0;
        for (Product product: products
             ) {
            if (max < product.getProductId()) {
                max = product.getProductId();
            }
        }
        return max + 1;
    }

    @Override
    public void update() {
        fileHandler.saveToFile(Constants.PRODUCT_FILE_PATH, products);
        System.out.println("Product database update successfully");
    }
}
