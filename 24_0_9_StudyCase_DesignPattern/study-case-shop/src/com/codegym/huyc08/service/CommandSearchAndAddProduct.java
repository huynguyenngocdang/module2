package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.service.chainAddToCart.HandlerAddToCartFinalize;
import com.codegym.huyc08.service.chainAddToCart.HandlerValidateProductEnoughQuantity;
import com.codegym.huyc08.service.chainAddToCart.HandlerValidateProductQuantity;
import com.codegym.huyc08.service.chainAddToCart.RequestToAddToCart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommandSearchAndAddProduct implements Command{
    private List<Product> products;
    private Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        products = new ArrayList<>();

        System.out.println("Input search queue (Do not input anything if you want to search all)");
        String search = SCANNER.nextLine().toLowerCase();
        StringBuilder regex = new StringBuilder();
        regex.append(AppConstant.SEARCH_REGEX);
        regex.append(search);
        regex.append(AppConstant.SEARCH_REGEX);

        for (Product product: SingletonListProduct.getInstance().getProducts()
             ) {
            if(product.getSellerId() != SingletonCurrentUser.getInstance().getCurrentUser().getUserId()) {
                validateAndAdd(product.getProductName().toLowerCase(), String.valueOf(regex), product);
                validateAndAdd(product.getProductType().toLowerCase(), String.valueOf(regex), product);
                validateAndAdd(product.getProductDescription().toLowerCase(), String.valueOf(regex), product);
                validateAndAdd(product.getProductManufacturer().toLowerCase(), String.valueOf(regex), product);
            }
        }

        if(products.isEmpty()) {
            System.out.println("Nothing to show");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i+1) + ". " + products.get(i).toString());
            }
            try {
                System.out.println("Input product line you want to add (Input 0 if you want to quit)");
                int choice = SCANNER.nextInt()-1;
                if(choice == AppConstant.USER_EXIT_CHOICE - 1) {
                    System.out.println("You choose to not add to cart");
                } else {
                    Product chooseProduct = getProduct(choice);
                    HandlerAddToCart addToCart2 = new HandlerAddToCartFinalize(null);
                    HandlerAddToCart validateQuantityEnough = new HandlerValidateProductEnoughQuantity(addToCart2);
                    HandlerAddToCart validateQuantity = new HandlerValidateProductQuantity(validateQuantityEnough);
                    RequestAddToCart requestAddToCart = new RequestToAddToCart(chooseProduct);
                    validateQuantity.handle(requestAddToCart);
                }

            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid input, please try again");
            }
        }
    }
    private Product getProduct(int choice) {
         return  products.get(choice);
    }
    private void validateAndAdd(String data, String regex, Product product) {
        Validator validator = new ValidatorRegexString(data, regex);
        if(validator.isCheck() && !products.contains(product)) {
            products.add(product);
        }
    }

}
