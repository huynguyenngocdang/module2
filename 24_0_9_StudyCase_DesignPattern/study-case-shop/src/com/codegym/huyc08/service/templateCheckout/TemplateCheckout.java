package com.codegym.huyc08.service.templateCheckout;

import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.codegym.huyc08.entity.PurchaseOrderFactory;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.SingletonCurrentUserDelivery;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonListPurchaseOrder;
import com.codegym.huyc08.service.SingletonShoppingCart;
import com.codegym.huyc08.service.Subject;

import java.util.Iterator;
import java.util.List;

public abstract class TemplateCheckout extends Subject {
    protected abstract boolean validateCash();

    protected abstract void updateProduct(CartItem currentCartLine);

    protected abstract void updateSeller(CartItem currentCartLine, double cost);

    protected abstract void updateBuyer(CartItem currentCartLine, double cost);

    protected abstract PurchaseOrder createPurchaseOrder(CartItem currentCartLine, double cost);

    public void checkout() {
        List<CartItem> cartItems = SingletonShoppingCart.getInstance().getCartItems();
        if(cartItems.isEmpty()) {
            System.out.println("There is nothing to checkout");
        } else {
            if (validateCash()) {
                List<PurchaseOrder> purchaseOrders = SingletonListPurchaseOrder.getInstance().getPurchaseOrders();
                Iterator<CartItem> cartItemIterator = cartItems.iterator();
                Observer productObserver = SingletonListProduct.getInstance();
                Observer normalUserObserver = SingletonListNormalUser.getInstance();
                Observer mailingObserver = SingletonCurrentUserDelivery.getInstance();
                Observer purchaseOrderObserver = SingletonListPurchaseOrder.getInstance();

                addObserver(productObserver);
                addObserver(normalUserObserver);
                addObserver(mailingObserver);
                addObserver(purchaseOrderObserver);

                while (cartItemIterator.hasNext()) {
                    CartItem currentCartLine = cartItemIterator.next();
                    double cost = calculateCost(currentCartLine);

                    updateProduct(currentCartLine);
                    updateSeller(currentCartLine, cost);
                    updateBuyer(currentCartLine, cost);

                    PurchaseOrder newPO = createPurchaseOrder(currentCartLine, cost);
                    purchaseOrders.add(newPO);

                    // remove cartItemLine:
                    cartItemIterator.remove();
                }

                notifyObserver();
                removeObserver(productObserver);
                removeObserver(normalUserObserver);
                removeObserver(mailingObserver);
                removeObserver(purchaseOrderObserver);
            }
        }

    }

    private double calculateCost(CartItem currentCartLine) {
        // Implement cost calculation based on the currentCartLine
        // This can be common logic for both with and without promotion scenarios
        return currentCartLine.getQuantity() * currentCartLine.getProduct().getProductPrice();
    }
}
