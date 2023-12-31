package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Promotion;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SingletonListPromotion implements Observer, GenerateId {
    private List<Promotion> promotions;
    private MyFileHandler fileHandler;
    private final Type PROMOTIONTYPE = new TypeToken<ArrayList<Promotion>>(){}.getType();
    private static SingletonListPromotion instance;
    private SingletonListPromotion(){
        fileHandler = new JsonFileHandler();
        promotions = (ArrayList<Promotion>) fileHandler.readFromFile(Constants.PROMOTION_FILE_PATH, PROMOTIONTYPE);
    }
    public static SingletonListPromotion getInstance() {
        if(instance == null) {
            instance = new SingletonListPromotion();
        }
        return instance;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    @Override
    public void update() {
        fileHandler.saveToFile(Constants.PROMOTION_FILE_PATH, promotions);
        System.out.println("Promotion database updated successfully");
    }

    @Override
    public int getNewId() {
        int max = 0;
        for (Promotion promotion: promotions
             ) {
            if(promotion.getPromotionId() > max) {
                max = promotion.getPromotionId();
            }
        }
        return max + 1;
    }
}
