package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.CartItem;

import java.util.ArrayList;
import java.util.List;

public class SingletonShoppingCart {
    private List<CartItem> cartItems;
    private static SingletonShoppingCart instance;


    public SingletonShoppingCart() {
        this.cartItems = new ArrayList<>();

    }
    public static SingletonShoppingCart getInstance() {
        if(instance == null) {
            instance = new SingletonShoppingCart();
        }
        return instance;
    }

    public void addToCart(CartItem cartItemAdd) {
        if(cartItems.isEmpty() || !itemExistInCart(cartItemAdd)) {
            cartItems.add(cartItemAdd);
        } else {
            for (CartItem currentCartItem: cartItems
                 ) {
                if(currentCartItem.getProduct().getProductId()== cartItemAdd.getProduct().getProductId()) {
                    double newAmount = cartItemAdd.getQuantity();
                    double currentAmount = currentCartItem.getQuantity();
                    currentCartItem.setQuantity(currentAmount + newAmount);
                }
            }
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    private boolean itemExistInCart(CartItem cartItem) {
        for (CartItem currentCartItem: cartItems
             ) {
            if(cartItem.getProduct().getProductId() == currentCartItem.getProduct().getProductId()){
                return true;
            }
        }
        return false;
    }
    public void displayCart(){
        if(cartItems.isEmpty()) {
            System.out.println("Your current cart is empty");
        } else {
                double productTotalCartPrice = 0;
                double currentUserBalance = SingletonCurrentUser.getInstance().getCurrentUser().getWalletBalance();
                System.out.println("Line\t Product ID \t Product \t Quantity \t Price \t\t Total Price");
                for (int i = 0; i < cartItems.size(); i++) {
                    CartItem currentCartItem = cartItems.get(i);
                    int productId = currentCartItem.getProduct().getProductId();
                    String productName = currentCartItem.getProduct().getProductName();
                    double productQuantity = currentCartItem.getQuantity();
                    double productPrice = currentCartItem.getProduct().getProductPrice();
                    double productTotalPrice = productPrice * productQuantity;
                    productTotalCartPrice += productTotalPrice;
                    System.out.println((i+1) +". \t\t\t" + productId + " \t\t\t " + productName + " \t " + productQuantity + " \t\t " + productPrice + " \t\t " + productTotalPrice);
            }
            System.out.println("Your current balance: " + currentUserBalance );
            System.out.println("Your balance after purchase: " + (currentUserBalance - productTotalCartPrice));
        }
    }
    public void removeCartLine(int choice) {
        if(choice >=0 && choice < cartItems.size()) {
            cartItems.remove(choice);
            System.out.println("Remove cart line " + (choice+1) + " successfully");
        } else {
            System.out.println("Invalid cart line, please try again");
        }
    }
    public void emptyCart(){
        if(cartItems.isEmpty()) {
            System.out.println("You have no cart item to empty");
        } else {
            cartItems.clear();
            System.out.println("Clean all cart item successfully");
        }
    }
    public CartItem getCartItem(int id) {
        if(!cartItems.isEmpty()) {
            for (CartItem cartItem: cartItems
            ) {
                if(cartItem.getProduct().getProductId() == id) {
                    return cartItem;
                }
            }
        } else {
            return null;
        }
        return null;
    }
}
