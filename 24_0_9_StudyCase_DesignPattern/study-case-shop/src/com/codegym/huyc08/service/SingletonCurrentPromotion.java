package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Promotion;

import java.util.List;

public class SingletonCurrentPromotion implements Observer{
    private List<Promotion> promotions;
    private Promotion currentPromotion;
    private static SingletonCurrentPromotion instance;
    private SingletonCurrentPromotion(){
        promotions = SingletonListPromotion.getInstance().getPromotions();
    }
    public static SingletonCurrentPromotion getInstance() {
        if(instance == null) {
            instance = new SingletonCurrentPromotion();
        }
        return instance;
    }

    public Promotion getCurrentPromotion() {
        return currentPromotion;
    }

    public void setCurrentPromotion(int promotionId) {
        for (Promotion promotion: promotions
             ) {
            if(promotion.getPromotionId() == promotionId) {
                currentPromotion = promotion;
                return;
            }
        };
    }
    public void getCurrentPromotionInformation(){
        System.out.println(currentPromotion.toString());
    }

    @Override
    public void update() {
        SingletonListPromotion.getInstance().update();
    }
}
