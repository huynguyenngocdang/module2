package com.codegym.huyc08.service.templateCheckout;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.PurchaseOrder;

public class CheckoutWithPromotion  extends  TemplateCheckout{
    @Override
    protected boolean validateCash() {
        return false;
    }

    @Override
    protected void updateProduct(CartItem currentCartLine) {

    }

    @Override
    protected void updateSeller(CartItem currentCartLine, double cost) {

    }

    @Override
    protected void updateBuyer(CartItem currentCartLine, double cost) {

    }

    @Override
    protected PurchaseOrder createPurchaseOrder(CartItem currentCartLine, double cost) {
        return null;
    }
}
