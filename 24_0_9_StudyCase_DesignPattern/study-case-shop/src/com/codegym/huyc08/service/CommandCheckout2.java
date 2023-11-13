package com.codegym.huyc08.service;

import com.codegym.huyc08.service.templateCheckout.CheckoutWithPromotion;
import com.codegym.huyc08.service.templateCheckout.CheckoutWithoutPromotion;
import com.codegym.huyc08.service.templateCheckout.TemplateCheckout;

import java.util.Scanner;

public class CommandCheckout2 implements Command{
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        Confirm confirmCheckout = new Confirmation("check out");
        if (confirmCheckout.isConfirm()) {
            Confirm confirmApplyCoupon = new Confirmation("Apply coupon");
            if(confirmApplyCoupon.isConfirm()){
                System.out.println("Input your promotion code");
                String promotionCode = SCANNER.nextLine();
                checkoutWithPromotion(promotionCode);
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
    private void checkoutWithPromotion(String promotionCode){
        TemplateCheckout checkout = new CheckoutWithPromotion(promotionCode);
        checkout.checkout();
    }
}
