package com.codegym.shop.Service;

import com.codegym.shop.Entity.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class ProductTest {
    public static void main(String[] args) {
        LinkedList<Product> products = getProductExample();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter("ProductList.json");
            gson.toJson(products, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileReader reader = new FileReader("ProductList.json");
            Type productType = new TypeToken<LinkedList<Product>>(){}.getType();
            LinkedList<Product> productRead = gson.fromJson(reader, productType);
            for (Product product: productRead
                 ) {
                System.out.println(product.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static LinkedList<Product> getProductExample() {
        Product product1 = new Product("Sony Xperia 3", "Phone", "Sony", 5000000, 10  );
        Product product2 = new Product("Sony Xperia 5", "Phone", "Sony", 10000000, 10, "Man"  );
        Product product3 = new Product("Iphone 7", "Phone", "Apple", 7000000, 10  );
        Product product4 = new Product("Iphone 15", "Phone", "Apple", 15000000, 10 , "Man" );
        LinkedList<Product> products = new LinkedList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        return products;
    }
}
