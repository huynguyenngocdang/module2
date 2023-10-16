package com.codegym.HuyC08.Service;

import com.codegym.HuyC08.Entity.Product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductService {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static LinkedList<Product> llProduct = productFileRead();
    private static LinkedList<Product> llProductCurrentUser;
    public static Product productCurrentUser;
    public static void productFileWrite(LinkedList<Product> llProduct) {
        try {
            FileWriter writer = new FileWriter("data/product.json");
            gson.toJson(llProduct, writer);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Can't write file");
            System.out.println(ioe.getMessage());
        }
    }
    public static LinkedList<Product> productFileRead() {
        try {
            FileReader reader = new FileReader("data/product.json");
            Type typeProduct = new TypeToken<LinkedList<Product>>(){}.getType();
            LinkedList<Product> llProductRead = gson.fromJson(reader, typeProduct);
            return llProductRead;
        } catch (FileNotFoundException fnf) {
            System.out.println("Can't read file");
            System.out.println(fnf.getMessage());
        }
        return null;
    }

    public static LinkedList<Product> productsCurrentUser(int currUserId) {
        llProduct = productFileRead();
        LinkedList<Product> llProductCurrentUser = new LinkedList<>();
        for (Product product: llProduct
             ) {
            if(product.getSellerId() == currUserId){
                llProductCurrentUser.add(product);
            }
        }
        return llProductCurrentUser;
    }
    private static void getProductsCurrentUser(int currUserId) {
        llProductCurrentUser = productsCurrentUser(currUserId);
    }
    public static void printProductsCurrentUser(int currUserId) {
        getProductsCurrentUser(currUserId);
        for (Product product: llProductCurrentUser
             ) {
            System.out.println(product.toString());
        }
    }

    public static double reduceCurrentUserCash(double amount) {
       return  (UserService.currUser.getUserCash() - amount);

    }

    public static boolean isEnoughUserCash(double amount) {
        return ( (UserService.currUser.getUserCash() - amount) >= 0 );
    }

    public static int getNewProductId() {
        int max = 0;
        for (Product product: llProduct) {
            if (max < product.getProductId()) {
                max = product.getProductId();
            }
        }
        return (max + 1);
    }
    public static String inputLongDescription() {
        var scannerNew = new Scanner(System.in);
        return scannerNew.nextLine();
    }

    public static void createNewProduct(int newProductId, int newProductSellerId, String newProductName, String newProductType, double newProductPrice, double newProductQuantity, String newProductManufacturer, String newProductDescription) {
        Product newProduct = new Product(newProductId, newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
        llProduct.add(newProduct);
        productFileWrite(llProduct);
    }

    public static void getCurrentProduct(int productId, int userId) {
        if( isProductBelongToUser(productId, userId)) {

            for (Product product:llProduct
            ) {
                if(product.getProductId() == productId) {
                    productCurrentUser = product;
                }
            }
        } else {
            System.out.println("You does not own this product");
        }
    }
    public static boolean isProductBelongToUser(int productId, int userId) {
        getProductsCurrentUser(userId);
        for (Product product:llProductCurrentUser
             ) {
            if(product.getProductId() == productId) {
                return true;
            }
        }
        return false;
    }

    public static void sortProductLinkedList(){
        Collections.sort(llProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductId() - o2.getProductId();
            }
    });
}
}