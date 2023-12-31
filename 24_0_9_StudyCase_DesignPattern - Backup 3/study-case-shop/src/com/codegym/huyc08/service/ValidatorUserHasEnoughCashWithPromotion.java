package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.CartItem;

import java.util.List;
import java.util.Map;

public class ValidatorUserHasEnoughCashWithPromotion implements Validator{
    private List<CartItem> cartItems;

    public ValidatorUserHasEnoughCashWithPromotion() {
        this.cartItems = SingletonShoppingCart.getInstance().getCartItems();
    }
    @Override
    public boolean isCheck() {
        if (cartItems.isEmpty()) {
            System.out.println("there is nothing to check");
            return false;
        } else {
            double totalPrice = 0;
            double walletBalance = SingletonCurrentUser.getInstance().getCurrentUser().getWalletBalance();
            double promotionAmount = SingletonCurrentPromotion.getInstance().getCurrentPromotion().getPromotionAmount();
            double promotionPercent = SingletonCurrentPromotion.getInstance().getCurrentPromotion().getPromotionPercent() * Constants.PERCENT;
            for (int i = 0; i < cartItems.size(); i++) {
                CartItem currentCartItem = cartItems.get(i);
                double productQuantity = currentCartItem.getQuantity();
                double productPrice = currentCartItem.getProduct().getProductPrice();
                double productTotalPrice = productPrice * productQuantity * (1 - promotionPercent) - promotionAmount;
                totalPrice += productTotalPrice;
            }
            return (walletBalance - totalPrice >= 0);
        }

    }
}
