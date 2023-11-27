package com.codegym.huyc08.validator;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonShoppingCart;

import java.util.List;

public class ValidatorUserHasEnoughCash implements Validator{
    private List<CartItem> cartItems;

    public ValidatorUserHasEnoughCash() {
        this.cartItems = SingletonShoppingCart.getInstance().getCartItems();
    }

    @Override
    public boolean isCheck() {
        if(cartItems.isEmpty()) {
            System.out.println("There is nothing to check");
            return false;
        } else {
            double productTotalCartPrice = 0;
            double currentUserBalance = SingletonCurrentUser.getInstance().getCurrentUser().getWalletBalance();
            for (int i = 0; i < cartItems.size(); i++) {
                CartItem currentCartItem = cartItems.get(i);
                double productQuantity = currentCartItem.getQuantity();
                double productPrice = currentCartItem.getProduct().getProductPrice();
                double productTotalPrice = productPrice * productQuantity;
                productTotalCartPrice += productTotalPrice;
            }
            return currentUserBalance >= productTotalCartPrice;
        }
    }
}
