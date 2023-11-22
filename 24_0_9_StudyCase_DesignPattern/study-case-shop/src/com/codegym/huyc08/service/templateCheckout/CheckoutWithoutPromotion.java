package com.codegym.huyc08.service.templateCheckout;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.codegym.huyc08.entity.PurchaseOrderFactory;
import com.codegym.huyc08.service.GenerateId;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonListPurchaseOrder;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorUserHasEnoughCash;

public class CheckoutWithoutPromotion extends TemplateCheckout {
    @Override
    protected boolean validateCash() {
        Validator validateUserEnoughCash = new ValidatorUserHasEnoughCash();
        return validateUserEnoughCash.isCheck();
    }

    @Override
    protected boolean validateAddress() {
        try {
            String address = SingletonCurrentUser.getInstance().getCurrentUser().getAddress();
            if(address.isBlank()) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }

    }

    @Override
    protected void updateProduct(CartItem currentCartLine) {
        Product thisProduct = SingletonListProduct.getInstance().getProduct(currentCartLine.getProduct().getProductId());
        thisProduct.setProductQuantity(thisProduct.getProductQuantity() - currentCartLine.getQuantity());

    }

    @Override
    protected void updateSeller(CartItem currentCartLine, double cost) {
        NormalUser seller = SingletonListNormalUser.getInstance().getCurrentUser(currentCartLine.getProduct().getSellerId());
        seller.setWalletBalance(seller.getWalletBalance() + cost);
    }

    @Override
    protected void updateBuyer(CartItem currentCartLine, double cost) {
        NormalUser buyer = SingletonCurrentUser.getInstance().getCurrentUser();
        buyer.setWalletBalance(buyer.getWalletBalance() - cost);
    }

    @Override
    protected PurchaseOrder createPurchaseOrder(CartItem currentCartLine, double cost) {
        GenerateId generateId = SingletonListPurchaseOrder.getInstance();
        PurchaseOrderFactory factory = new PurchaseOrderFactory();
        int newPOId = generateId.getNewId();
        int userId = SingletonCurrentUser.getInstance().getCurrentUser().getUserId();
        int sellerId = currentCartLine.getProduct().getSellerId();
        int productId = currentCartLine.getProduct().getProductId();
        double productPrice = currentCartLine.getProduct().getProductPrice();
        double productQuantity = currentCartLine.getQuantity();
        double totalPrice = cost;
        PurchaseOrder newPO = factory.createNewPO(newPOId, userId, sellerId, productId, productPrice, productQuantity, totalPrice);
        return newPO;
    }
}
