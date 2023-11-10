package com.codegym.huyc08.service;

import com.codegym.huyc08.service.templateCheckout.CheckoutWithPromotion;
import com.codegym.huyc08.service.templateCheckout.CheckoutWithoutPromotion;
import com.codegym.huyc08.service.templateCheckout.TemplateCheckout;

public class CommandCheckout2 implements Command{
    @Override
    public void execute() {
        Confirm confirmCheckout = new Confirmation("check out");
        if (confirmCheckout.isConfirm()) {
            Confirm confirmApplyCoupon = new Confirmation("Apply coupon");
            if(confirmApplyCoupon.isConfirm()){
                checkoutWithPromotion();
            }else {
                checkoutWithoutPromotion();
            }
        } else {
            System.out.println("You choose not to check out");
        }
    }
    private void checkoutWithoutPromotion(){
        TemplateCheckout checkout = new CheckoutWithoutPromotion();
        checkout.checkout();
    }
    private void checkoutWithPromotion(){
        TemplateCheckout checkout = new CheckoutWithPromotion();
        checkout.checkout();
    }
}
