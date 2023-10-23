package com.codegym.huy_c08.service;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.Product;
import com.codegym.huy_c08.entity.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    private ArrayList<Product> products;
    private final MyFileHandler fileHandler = new MyFileHandler();
    private final Type productType = new TypeToken<ArrayList<Product>>(){}.getType();
    private Product currentUserProduct;

    public ProductService() {
        this.products = (ArrayList<Product>) fileHandler.readFromFile(Constants.PRODUCT_FILE_PATH, productType);
    }

    public void getCurrentUserProductList(int currentUserId) {
        for (Product product: products
             ) {
            if(product.getSellerId() == currentUserId) {
                System.out.println(product.toString());
            }
        }
    }

    public  int getNewProductId() {
        int max = 0;
        for (Product product: products) {
            if (max < product.getProductId()) {
                max = product.getProductId();
            }
        }
        return (max + 1);
    }

    public  String inputLongDescription() {
        Scanner scannerNew = new Scanner(System.in);
        return scannerNew.nextLine();
    }
    public void updateProduct() {
        fileHandler.saveToFile(Constants.PRODUCT_FILE_PATH, products);
    }
    public void createNewProduct(int newProductId, int newProductSellerId, String newProductName, String newProductType, double newProductPrice, double newProductQuantity, String newProductManufacturer, String newProductDescription) {
        Product newProduct = new Product(newProductId, newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
        products.add(newProduct);
        updateProduct();
    }

    public boolean isProductBelongToUser(int productId, int userId) {
        for (Product product: products
        ) {
            if(product.getProductId() == productId && product.getSellerId() == userId) {
                return true;
            }
        }
        return false;
    }

    public Product getProductCurrentUser(int productId, int userId) {
        for (Product product: products
        ) {
            if(product.getProductId() == productId && product.getSellerId() == userId) {
                currentUserProduct = product;
                return product;
            }
        }
        return null;
    }
    public void printAllProduct() {
        for (Product product : products
                ) {
            System.out.println(product.toString());
        }
    }
    public void changeProductName(String newProductName) {
        currentUserProduct.setProductName(newProductName);
        updateProduct();
    }
    public void changeProductType(String newProductType) {
        currentUserProduct.setProductType(newProductType);
        updateProduct();
    }
    public void changeProductPrice(double newProductPrice) {
        currentUserProduct.setProductPrice(newProductPrice);
        updateProduct();
    }
    public void changeProductQuantity(double newProductQuantity) {
        currentUserProduct.setProductQuantity(newProductQuantity);
        updateProduct();
    }
    public void changeProductManufacturer(String newProductManufacturer) {
        currentUserProduct.setProductManufacturer(newProductManufacturer);
        updateProduct();
    }
    public void changeProductDescription(String newProductDescription) {
        currentUserProduct.setProductDescription(newProductDescription);
        updateProduct();
    }
    public double getCurrentProductPrice(){
        return currentUserProduct.getProductPrice();
    }
    public double getCurrentProductQuantity(){
        return currentUserProduct.getProductQuantity();
    }

    public double getPriceChange(double newProductData, double currentProductQuantity, double currentProductPrice) {
        double newTotalPrice;
        double priceChange;
        double originTotalPrice;
        newTotalPrice = newProductData * currentProductQuantity;
        originTotalPrice = currentProductPrice * currentProductQuantity;
        priceChange = newTotalPrice - originTotalPrice;
        return priceChange;
    }

}
