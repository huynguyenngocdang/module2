package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.RequestNewPromotion;

import java.util.Scanner;

public class InputNewPromotionPercent implements HandlerNewPromotion {
    private  final Scanner SCANNER;
    private HandlerNewPromotion next;

    public InputNewPromotionPercent(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        System.out.println("Input your new promotion percent (0-100)");
        double newPercent = SCANNER.nextDouble();
        requestNewPromotion.setPromotionPercent(newPercent);
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
