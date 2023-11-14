package com.codegym.huyc08.service.chainCreateNewPromotion;

import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.entity.PromotionFactory;
import com.codegym.huyc08.service.GenerateId;
import com.codegym.huyc08.service.HandlerNewPromotion;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.RequestNewPromotion;
import com.codegym.huyc08.service.SingletonListPromotion;
import com.codegym.huyc08.service.Subject;

import java.util.Scanner;

public class CreateNewPromotion extends Subject implements HandlerNewPromotion {
    private  final Scanner SCANNER;
    private HandlerNewPromotion next;

    public CreateNewPromotion(HandlerNewPromotion next) {
        this.SCANNER = new Scanner(System.in);
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestNewPromotion requestNewPromotion) {
        GenerateId newPromotionIdMethod = SingletonListPromotion.getInstance();

        int newId = newPromotionIdMethod.getNewId();
        String newCode = requestNewPromotion.getPromotionCode();
        String startDate = requestNewPromotion.getPromotionDateStart();
        String endDate = requestNewPromotion.getPromotionDateEnd();
        double amount = requestNewPromotion.getPromotionAmount();
        double percent = requestNewPromotion.getPromotionPercent();

        PromotionFactory factory = new PromotionFactory();
        Promotion newPromotion = factory.createPromotion(newId, newCode, startDate, endDate, amount, percent);

        Observer observer = SingletonListPromotion.getInstance();
        addObserver(observer);
        SingletonListPromotion.getInstance().getPromotions().add(newPromotion);
        notifyObserver();
        removeObserver(observer);

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
