package com.codegym.huyc08.service.chainAddToCart;

import com.codegym.huyc08.service.HandlerAddToCart;
import com.codegym.huyc08.service.RequestAddToCart;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonShoppingCart;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDoubleNotNegative;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandlerValidateProductQuantity implements HandlerAddToCart {
    private HandlerAddToCart next;
    private final Scanner SCANNER = new Scanner(System.in);

    public HandlerValidateProductQuantity(HandlerAddToCart next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestAddToCart requestAddToCart) {
        try {
            double currentCartItemQuantity = SingletonShoppingCart.getInstance().getCartItem(requestAddToCart.getProduct().getProductId()).getQuantity();
            double productCurrentQuantity = SingletonListProduct.getInstance().getProduct(requestAddToCart.getProduct().getProductId()).getProductQuantity();
            double currentAvailable = productCurrentQuantity - currentCartItemQuantity;

            System.out.println("Current available " + currentAvailable );
            System.out.println("Input product quantity you want to purchase");
            double productQuantity = SCANNER.nextInt();

            Validator validator = new ValidatorDoubleNotNegative(productQuantity);
            if(validator.isCheck()){
                requestAddToCart.setQuantity(productQuantity);
                System.out.println("Validate product quantity not negative successfully");
                return true;
            } else {
                System.out.println("Product quantity can't be negative");
                return false;
            }

        } catch (NullPointerException e) {
            double productCurrentQuantity = SingletonListProduct.getInstance().getProduct(requestAddToCart.getProduct().getProductId()).getProductQuantity();
            System.out.println("Current available " + productCurrentQuantity );
            System.out.println("Input product quantity you want to purchase");
            double productQuantity = SCANNER.nextInt();
            Validator validator = new ValidatorDoubleNotNegative(productQuantity);
            if(validator.isCheck()) {
                requestAddToCart.setQuantity(productQuantity);
                System.out.println("Validate product quantity not negative successfully");
                return true;
            } else {
                System.out.println("Product quantity can't be negative");
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            return false;
        }
    }

    @Override
    public void handle(RequestAddToCart requestAddToCart) {
        if(!doHandle(requestAddToCart)){
            return;
        }
        if(next != null) {
            next.handle(requestAddToCart);
        }
    }
}
