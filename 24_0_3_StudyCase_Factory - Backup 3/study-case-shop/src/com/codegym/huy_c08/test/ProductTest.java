package com.codegym.huy_c08.test;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.Product;
import com.codegym.huy_c08.service.MyFileHandler;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductTest {

    public static void main(String[] args) {
        ArrayList<Product> productArrayListWrite = new ArrayList<>();
        MyFileHandler fileHandler = new MyFileHandler();
        productArrayListWrite.add(new Product(1, 1, "Iphone7", "Phone", 700,10,"Apple" ));
        productArrayListWrite.add(new Product(2, 2, "Iphone15", "Phone", 1000,10,"Apple" ));
        productArrayListWrite.add(new Product(3, 2, "Iphone7", "Phone", 1000,10,"Apple" ));
        fileHandler.saveToFile(Constants.PRODUCT_FILE_PATH, productArrayListWrite);

        ArrayList<Product>  productArrayListRead = new ArrayList<>();
        Type producType = new TypeToken<ArrayList<Product>>(){}.getType();
        productArrayListRead = (ArrayList<Product>) fileHandler.readFromFile(Constants.PRODUCT_FILE_PATH, producType);
        for (Product product:productArrayListRead
             ) {
            System.out.println(product.toString());
        }
    }
}
