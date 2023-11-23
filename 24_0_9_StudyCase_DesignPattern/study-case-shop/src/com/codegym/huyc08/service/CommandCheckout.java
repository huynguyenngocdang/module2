package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.service.templateCheckout.CheckoutWithPromotion;
import com.codegym.huyc08.service.templateCheckout.CheckoutWithoutPromotion;
import com.codegym.huyc08.service.templateCheckout.TemplateCheckout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CommandCheckout implements Command{
    private  Scanner SCANNER;
    @Override
    public void execute() {
        SCANNER = new Scanner(System.in);
        Confirm confirmCheckout = new Confirmation("check out");
        if (confirmCheckout.isConfirm()) {
            Confirm confirmApplyCoupon = new Confirmation("Apply coupon");
            if(confirmApplyCoupon.isConfirm()){
                System.out.println("Input your promotion code");
                String promotionCode = SCANNER.nextLine();
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_PATTERN_REGEX);
                    String todayDateZeroTime = dateFormat.format(new Date());

                    Promotion thisPromotion = SingletonListPromotion.getInstance().getPromotionWithCode(promotionCode);
                    String endDate = thisPromotion.getPromotionDateEnd();
                    Validator validator = new ValidatorDateBeforeDate(todayDateZeroTime, endDate);
                    if(validator.isCheck()) {
                        checkoutWithPromotion(promotionCode);
                    } else {
                        System.out.println("Promotion code expired, please try another code");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Invalid promotion code, please try again");
                }
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
