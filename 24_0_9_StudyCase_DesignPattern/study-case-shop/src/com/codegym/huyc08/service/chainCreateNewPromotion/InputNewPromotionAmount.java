package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;

import java.util.Scanner;

public class InputNewPromotionAmount implements HandlerNewPromotion {
    private  final Scanner SCANNER;
    private HandlerNewPromotion next;

    public InputNewPromotionAmount(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        System.out.println("Input your new promotion amount (>= 0)");
        double newAmount = SCANNER.nextDouble();
        requestNewPromotion.setPromotionAmount(newAmount);
        return true;
    }
    @Override
    public void handle(RequestNewPromotion requestNewPromotion) {
        if(!doHandle(requestNewPromotion)) {
            return;
        }
        if(next!=null){
            next.handle(requestNewPromotion);
        }
    }
}
